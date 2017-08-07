package io.github.gitwebx.hubiitism;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClubsActivity extends AppCompatActivity implements FeedAdapter.FeedItemClickListener {
    public static List<Club> clubs = new ArrayList<>();
    TinyDB db;
    ArrayList<FeedItem> feedItems;
    RecyclerView rv;

    //TODO: Add snackbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.clubs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                openSettingsActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        db = new TinyDB(this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (!pref.contains("ClubsAppHasRun")) {
            SharedPreferences.Editor edit = pref.edit();
            edit.putBoolean("ClubsAppHasRun", true);
            edit.apply();
            loadFromAssets();
            openSettingsActivity();
        } else {
            clubs = new ArrayList<>();
            List<Object> x = (db.getListObject("clubList", Club.class));
            for (Object o : x) {
                clubs.add((Club) o);
            }
        }

        feedItems = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        boolean hasChosen = false;
        for (int i = 0; i < clubs.size(); i++) {
            Club club = clubs.get(i);
            if (club.isSelected()) {
                requestQueue.add(createRequest(club.getFbID()));
                hasChosen = true;
            }
        }

        if (!hasChosen) {
            Toast.makeText(this, "Please select atleast one club!", Toast.LENGTH_LONG).show();
            openSettingsActivity();
        }

        rv = (RecyclerView) findViewById(R.id.rv_feed_list);

        requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<JSONObject>() {
            @Override
            public void onRequestFinished(Request<JSONObject> request) {
                Collections.sort(feedItems, new Comparator<FeedItem>() {
                    @Override
                    public int compare(FeedItem o1, FeedItem o2) {
                        return -o1.getTime().compareTo(o2.getTime());
                    }
                });
                if (feedItems.size() > 100)
                    feedItems.subList(0, 100);
                loadRecyclerView();
            }
        });
    }

    private void loadRecyclerView() {
        rv.setAdapter(new FeedAdapter(feedItems, this));
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rv.setHasFixedSize(false);

        findViewById(R.id.pb_loading).setVisibility(View.GONE);
    }

    void loadFromAssets() {
        Scanner sc;
        try {
            sc = new Scanner(getAssets().open("List.csv"));
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                String[] ln = sc.nextLine().split(",");
                clubs.add(new Club(ln[1], ln[0], ln[2]));
                Log.i("Clubs : ", ln[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openSettingsActivity() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        db.putListObject("clubList", new ArrayList<Object>(clubs));
        super.onDestroy();
    }

    private JsonObjectRequest createRequest(String s) {
        String url = "https://graph.facebook.com/" + s + "/?fields=name,picture,feed.limit(100){message,created_time,full_picture,story}&access_token=1846580672284397|DujyrCe4ZNZUGz0jkPT0L-lDhRE";
        return new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name = response.getString("name");
                    String profilePic = response.getJSONObject("picture").getJSONObject("data").getString("url");
                    JSONArray arr = response.getJSONObject("feed").getJSONArray("data");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject current = arr.getJSONObject(i);

                        String msg = (current.has("message")) ? current.getString("message") :
                                (current.has("story") ? current.getString("story") : "This post cannot be displayed");
                        String time = current.getString("created_time");
                        String story = current.has("story") ? current.getString("story") : "Can't fetch story";
                        String image = current.has("full_picture") ? current.getString("full_picture") : null;
                        String id = current.getString("id");
                        feedItems.add(new FeedItem(name, profilePic, msg, time, story, image, id));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    findViewById(R.id.tv_error).setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                findViewById(R.id.tv_error).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClickItem(FeedItem fd) {
        PostActivity.feedItem = fd;
        startActivity(new Intent(this, PostActivity.class));
    }
}

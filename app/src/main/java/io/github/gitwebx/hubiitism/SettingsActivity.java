package io.github.gitwebx.hubiitism;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static io.github.gitwebx.hubiitism.ClubsActivity.clubs;

public class SettingsActivity extends AppCompatActivity {
    List<Club> filteredList = new ArrayList<>();
    RecyclerView rv;
    TinyDB db;

    @Override
    protected void onDestroy() {
        db.putListObject("clubList", new ArrayList<Object>(clubs));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new TinyDB(this);
        setContentView(R.layout.activity_settings);
        clubs = sortList(clubs);

        rv = (RecyclerView) findViewById(R.id.rv_club_list);
        rv.setAdapter(new ClubsAdapter(clubs));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        EditText editText = (EditText) findViewById(R.id.et_query);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase();
                filteredList.removeAll(clubs);
                for (Club i : filteredList) {
                    String cbName = i.getClubName();
                    for (Club j : clubs) {
                        String cbName2 = j.getClubName();
                        if (cbName.equals(cbName2)) {
                            clubs.remove(j);
                            clubs.add(i);
                        }
                    }
                }
                filteredList = new ArrayList<>();

                for (Club i : clubs) {
                    if (i.getClubName().toLowerCase().contains(query)) {
                        filteredList.add(i);
                    }
                }

                filteredList = sortList(filteredList);

                RecyclerView.Adapter x = new ClubsAdapter(filteredList);
                rv.setAdapter(x);
                x.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_done);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.putListObject("clubList", new ArrayList<Object>(clubs));
                startActivity(new Intent(SettingsActivity.this, ClubsActivity.class));
            }
        });

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0)
                    fab.hide();
                else if (dy < 0)
                    fab.show();
            }
        });
    }

    List<Club> sortList(List<Club> x) {
        Collections.sort(x, new Comparator<Club>() {
            @Override
            public int compare(Club o1, Club o2) {
                return -Boolean.compare(o1.isSelected(), o2.isSelected());
            }
        });
        return x;
    }
}

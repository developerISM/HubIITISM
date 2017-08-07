package io.github.gitwebx.hubiitism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    List<Club> filteredList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ClubsActivity.clubs = sortList(ClubsActivity.clubs);

        rv = (RecyclerView) findViewById(R.id.rv_club_list);
        rv.setAdapter(new ClubsAdapter(ClubsActivity.clubs));
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
                filteredList.removeAll(ClubsActivity.clubs);
                for (Club i : filteredList) {
                    String cbName = i.getClubName();
                    for (Club j : ClubsActivity.clubs) {
                        String cbName2 = j.getClubName();
                        if (cbName.equals(cbName2)) {
                            ClubsActivity.clubs.remove(j);
                            ClubsActivity.clubs.add(i);
                        }
                    }
                }
                filteredList = new ArrayList<>();

                for (Club i : ClubsActivity.clubs) {
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

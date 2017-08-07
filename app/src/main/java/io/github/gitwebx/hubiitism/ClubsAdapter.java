package io.github.gitwebx.hubiitism;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Manan on 7/1/2017.
 */

public class ClubsAdapter extends RecyclerView.Adapter<ClubsAdapter.ClubViewHolder> {
    List<Club> clubs;

    ClubsAdapter(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.club_item, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClubViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public void onViewRecycled(ClubViewHolder holder) {
        super.onViewRecycled(holder);

        CheckBox cb = (CheckBox) holder.x.findViewById(R.id.cb_club_selected);
        cb.setOnCheckedChangeListener(null);
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {
        View x;

        ClubViewHolder(View itemView) {
            super(itemView);
            x = itemView;
        }

        void bind(final int position) {
            final Club club = clubs.get(position);
            TextView nametv = x.findViewById(R.id.tv_club_name);
            TextView cattv = x.findViewById(R.id.tv_club_category);

            nametv.setText(club.getClubName());
            cattv.setText(club.getCategory());

            CheckBox cb = x.findViewById(R.id.cb_club_selected);
            cb.setChecked(club.isSelected());
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    club.setSelected(isChecked);
                }
            });
        }
    }
}

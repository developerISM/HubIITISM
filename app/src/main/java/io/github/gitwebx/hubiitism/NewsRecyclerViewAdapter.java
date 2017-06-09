package io.github.gitwebx.hubiitism;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static io.github.gitwebx.hubiitism.R.drawable.c;

/**
 * Created by hp on 09-06-2017.
 */

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NumberViewHolder> {

   List<News> listNews;

    public NewsRecyclerViewAdapter(Context context, List<News> objects) {

        listNews=objects;
    }



    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();

            int layoutIdForListItem = R.layout.list_item;
            LayoutInflater inflater = LayoutInflater.from(context);
            boolean shouldAttachToParentImmediately = false;

            View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
            NumberViewHolder viewHolder = new NumberViewHolder(view);

            return viewHolder;


    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {

        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        {
            return listNews.size();
        }

    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView listItemNumberView;
        ImageView image;
        TextView too;

        public NumberViewHolder(View itemView) {
            super(itemView);


            TextView ntv = (TextView) itemView.findViewById(R.id.news);
            TextView ttv = (TextView) itemView.findViewById(R.id.time);
            TextView dtv = (TextView) itemView.findViewById(R.id.date);



        }


        void bind(int listIndex) {
            TextView ntv = (TextView) itemView.findViewById(R.id.news);
            TextView ttv = (TextView) itemView.findViewById(R.id.time);
            TextView dtv = (TextView) itemView.findViewById(R.id.date);
            String time = listNews.get(listIndex).getmTime();
            ntv.setText(listNews.get(listIndex).getmNews());
            dtv.setText(time.substring(0, 10));
            ttv.setText(time.substring(11, 16));
               /* image.setImageResource(wordlist.get(listIndex).getImageResourceId());
                listItemNumberView.setText(wordlist.get(listIndex).getDefaultTranslation());
                too.setText(wordlist.get(listIndex).getMiwokTranslation());*/

        }
    }
}

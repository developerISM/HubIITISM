package io.github.gitwebx.hubiitism;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Manan on 6/30/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedAdapterViewHolder> {
    ArrayList<FeedItem> feedItems;
    FeedItemClickListener feedItemClickListener;

    FeedAdapter(ArrayList<FeedItem> feedItems, FeedItemClickListener feedItemClickListener) {
        this.feedItems = feedItems;
        this.feedItemClickListener = feedItemClickListener;
    }

    public static String getDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        TimeZone utcZone = TimeZone.getTimeZone("UTC");
        sdf.setTimeZone(utcZone);

        String dt;
        Date t;
        try {
            t = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        sdf = new SimpleDateFormat("MMMM' 'dd', 'yyyy'\n'HH:mm");
        sdf.setTimeZone(TimeZone.getDefault());
        dt = sdf.format(t);

        return dt;
    }

    @Override
    public FeedAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.feed_item, parent, false);
        return new FeedAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedAdapterViewHolder holder, int position) {
        holder.bind(feedItems.get(position));
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public interface FeedItemClickListener {
        void onClickItem(FeedItem fd);
    }

    public class FeedAdapterViewHolder extends RecyclerView.ViewHolder {

        View itemView;

        public FeedAdapterViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

        }

        public void bind(final FeedItem feedItem) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedItemClickListener.onClickItem(feedItem);
                }
            });

            TextView authorView = (TextView) itemView.findViewById(R.id.tv_feed_author);
            TextView feedView = (TextView) itemView.findViewById(R.id.tv_post);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_full_picture);
            ImageView profileView = (ImageView) itemView.findViewById(R.id.civ_author_img);
            TextView timeView = itemView.findViewById(R.id.tv_time);

            if (feedItem.getStory().equals("Can't fetch story")) {
                authorView.setText(feedItem.getAuthor() + " made a post.");
            } else {
                authorView.setText(feedItem.getStory());
            }

            if (!feedItem.getMessage().equals("This post cannot be displayed")) {
                feedView.setText(feedItem.getMessage());
            } else {
                feedView.setVisibility(View.GONE);
            }

            if (feedItem.getImgUrl() != null) {
                Picasso.with(itemView.getContext())
                        .load(feedItem.getImgUrl())
                        .into(imageView);
                imageView.setContentDescription(feedItem.getStory());
            }

            timeView.setText(getDate(feedItem.getTime()));

            Picasso.with(itemView.getContext())
                    .load(feedItem.getProfilePic()).fit()
                    .into(profileView);
        }
    }
}

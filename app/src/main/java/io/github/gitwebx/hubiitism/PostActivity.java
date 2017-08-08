package io.github.gitwebx.hubiitism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import uk.co.senab.photoview.PhotoViewAttacher;

import static io.github.gitwebx.hubiitism.FeedAdapter.getDate;

public class PostActivity extends AppCompatActivity {
    static FeedItem feedItem;
    PhotoViewAttacher mAttacher;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String url = "https://fb.com/" + feedItem.getId();

        switch (item.getItemId()) {
            case R.id.internet:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Checkout this post:- " + url + "\nShared via hubISM");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setTitle(feedItem.getAuthor() + "'s post");

        TextView authorView = (TextView) findViewById(R.id.tv_feed_author);
        TextView feedView = (TextView) findViewById(R.id.tv_post);
        final ImageView imageView = (ImageView) findViewById(R.id.iv_full_picture);
        ImageView profileView = (ImageView) findViewById(R.id.civ_author_img);

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
            Picasso.with(this)
                    .load(feedItem.getImgUrl())
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            imageView.setImageBitmap(bitmap);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {

                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                        }
                    });
            imageView.setContentDescription(feedItem.getStory());
            mAttacher = new PhotoViewAttacher(imageView);
        }

        TextView timeView = (TextView) findViewById(R.id.tv_time);
        timeView.setText(getDate(feedItem.getTime()));

        Picasso.with(this)
                .load(feedItem.getProfilePic()).fit()
                .into(profileView);
    }
}

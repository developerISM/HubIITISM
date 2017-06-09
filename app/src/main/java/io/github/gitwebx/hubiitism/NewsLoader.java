package io.github.gitwebx.hubiitism;


import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Manan J on 26/01/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;

    public NewsLoader(ClubActivity context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null)
            return null;

        List<News> feed = QueryUtils.fetchFeedData(mUrl);

        return feed;
    }
}

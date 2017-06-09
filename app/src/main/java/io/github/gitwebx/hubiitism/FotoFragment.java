package io.github.gitwebx.hubiitism;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manan J on 26/01/17.
 */

public class FotoFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter mAdapter;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_list, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.list);
        mAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());

        lv.setAdapter(mAdapter);

        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            //mEmptyStateTextView.setText("No Internet Connection");
            Snackbar.make(rootView, "No internet connection", Snackbar.LENGTH_INDEFINITE).show();
        }
        return rootView;
    }

    @Override
    public android.support.v4.content.Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader((ClubActivity) getActivity(), ValueStore.getURL(8));
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<List<News>> loader, List<News> data) {
        View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mAdapter.clear();

        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        } else
            Snackbar.make(rootView, "No news right now", Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<List<News>> loader) {
        mAdapter.clear();
    }
}


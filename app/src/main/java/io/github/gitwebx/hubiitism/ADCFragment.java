package io.github.gitwebx.hubiitism;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.defaultValue;

/**
 * Created by Manan J on 26/01/17.
 */

public class ADCFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final int NEWS_LOADER_ID = 1;
    private NewsRecyclerViewAdapter mAdapter;
    private View rootView;
    int position;
    RecyclerView mlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_list, container, false);




        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("key", defaultValue);
            position=myInt;
        }
        mlist = (RecyclerView) rootView.findViewById(R.id.rv_numbers);

        LinearLayoutManager la = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mlist.setLayoutManager(la);
        mlist.setHasFixedSize(true);
        mAdapter = new NewsRecyclerViewAdapter(new ArrayList<News>());
        mlist.setAdapter(mAdapter);




       /* ListView lv = (ListView) rootView.findViewById(R.id.list);
        mAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());

        lv.setAdapter(mAdapter);*/

        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            Snackbar.make(rootView, "No internet connection", Snackbar.LENGTH_INDEFINITE).show();
        }
        return rootView;
    }

    @Override
    public android.support.v4.content.Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader((ClubActivity) getActivity(), ValueStore.getURL(position));
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<List<News>> loader, List<News> data) {
        View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();


        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
            mlist.setAdapter(mAdapter);

        } else
            Snackbar.make(rootView, "No news right now", Snackbar.LENGTH_INDEFINITE).show();
    }


    @Override
    public void onLoaderReset(android.support.v4.content.Loader<List<News>> loader) {

    }
}


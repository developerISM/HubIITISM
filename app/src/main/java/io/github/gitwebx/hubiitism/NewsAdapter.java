package io.github.gitwebx.hubiitism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Manan J on 26/01/17.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News current = getItem(position);

        TextView ntv = (TextView) listItemView.findViewById(R.id.news);


        TextView ttv = (TextView) listItemView.findViewById(R.id.time);
        TextView dtv = (TextView) listItemView.findViewById(R.id.date);
        String time = current.getmTime();
        ntv.setText(current.getmNews());
        dtv.setText(time.substring(0, 10));
        ttv.setText(time.substring(11, 16));
        return listItemView;
    }
}

package io.github.gitwebx.hubiitism;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * A simple {@link Fragment} subclass.
 */
public class Section extends Fragment {
    int rID;

    public Section() {
        // Required empty public constructor
    }
    ImageView imageView;
    PhotoViewAttacher mAttacher;

    void setrID(int rID){
        this.rID = rID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewa= inflater.inflate(R.layout.fragment_section, container, false);
        ImageView imageview=(ImageView)viewa.findViewById(R.id.secimgview);
        imageview.setImageResource(rID);
        mAttacher = new PhotoViewAttacher(imageview);
        return viewa;
    }

}

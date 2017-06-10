package io.github.gitwebx.hubiitism;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import static android.R.attr.fragment;

/**
 * Created by Manan J on 26/01/17.
 */

public class ClubAdapter extends FragmentStatePagerAdapter {
    private String tabTitles[] = new String[]{"Manthan", "LITC", "LITM", "ADC",
            "Robo ISM", "E-Cell", "Cyber Labs", "AIESEC", "Fotofreaks", "Mailer Daemon", "The Hub"};

    public ClubAdapter(FragmentManager fm) {
        super(fm);
    }


            int not=11;
            Fragment fragment;
    @Override
    public Fragment getItem(int position) {
        for (int i = 0; i < not ; i++) {
            if (i == position) {
                fragment =new ADCFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key", i);
                fragment.setArguments(bundle);
                break;
            }
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

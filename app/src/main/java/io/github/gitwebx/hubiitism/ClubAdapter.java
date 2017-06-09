package io.github.gitwebx.hubiitism;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Manan J on 26/01/17.
 */

public class ClubAdapter extends FragmentStatePagerAdapter {
    private String tabTitles[] = new String[]{"Manthan", "LITC", "LITM", "ADC",
            "Robo ISM", "E-Cell", "Cyber Labs", "AIESEC", "Fotofreaks", "Mailer Daemon", "The Hub"};

    public ClubAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new ManthanFragment();
        else if (position == 1)
            return new LITCFragment();
        else if (position == 2)
            return new LITMFragment();
        else if (position == 3)
            return new ADCFragment();
        else if (position == 4)
            return new RoboFragment();
        else if (position == 5)
            return new GenesisFragment();
        else if (position == 6)
            return new CyberFragment();
        else if (position == 7)
            return new AIESECFragment();
        else if (position == 8)
            return new FotoFragment();
        else if (position == 9)
            return new MDFragment();

        return new HubFragment();
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

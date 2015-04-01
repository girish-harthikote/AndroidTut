package com.quotes.studiostore.swipefragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Girish.Harthikote on 3/1/2015.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Frag Tab1","Frag Tab2","Frag Tab3","Frag Tab4","Frag Tab5"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new TabFragment1();
        } else if(position == 1) {
            return new TabFragment2();
        } else if(position == 2) {
            return new TabFragment3();
        }else if(position == 3) {
            return new TabFragment4();
        } else if(position == 4) {
            return new TabFragment5();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

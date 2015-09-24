package com.fgyt;

import com.fgyt.fragments.FacebookFragment;
import com.fgyt.fragments.GooglePlusFragment;
import com.fgyt.fragments.TwitterFragment;
import com.fgyt.fragments.YouTubeFragment;
import com.fgyt.service.FacebookService;
import com.fgyt.utils.Actions;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.IntentService;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends Activity implements OnPageChangeListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    
    PagerTabStrip mPagerStrip;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Intent facebookIntent = new Intent(getApplicationContext(), FacebookService.class);
        facebookIntent.setAction(Actions.ACTION_FB_GET_ALL_POSTS);
        startService(facebookIntent);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(this);

        // For each of the sections in the app, add a tab to the action bar.
        
        mPagerStrip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
		mPagerStrip.setBackgroundColor(getResources().getColor(getBackgroundColor(0)));
        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(getBackgroundColor(0))));
        Intent facebookIntent = new Intent(getApplicationContext(), FacebookService.class);
        startService(facebookIntent);
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
    	

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
			case 0:
				return new FacebookFragment();

			case 1:
				return new GooglePlusFragment();

			case 2:
				return new TwitterFragment();

			case 3:
				return new YouTubeFragment();

			default:
				return new FacebookFragment();

            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "facebook";
                case 1:
                    return "google+";
                case 2:
                    return "twitter";
                case 3:
                	return "youTube";
            }
            return null;
        }
    }


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {
		// TODO Auto-generated method stub
		

	}


	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		mPagerStrip.setBackgroundColor(getResources().getColor(getBackgroundColor(position)));
		   ActionBar mActionBar = getActionBar();
		mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(getBackgroundColor(position))));
	}

	
	public static int getBackgroundColor(int position) {
		int colorId = -1;
		
		switch (position) {
		case 0:
			colorId = R.color.facebook_background_color;
			break;

		case 1:
			colorId = R.color.googleplus_background_color;
			break;

		case 2:
			colorId = R.color.twitter_background_color;
			break;

		case 3:
			colorId = R.color.youtube_background_color;
			break;
		}
		
		return colorId;
		
		
	}
}

package com.androidbegin.viewpagertutorial;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;

import io.fabric.sdk.android.Fabric;
import java.io.File;

public class MainActivity extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;

    String popRank;
    String countryName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        // configure Flurry
        FlurryAgent.setLogEnabled(false);
        // init Flurry
        FlurryAgent.init(this, "DMJP6ZTMZ4QJCZ822Y6Y");



        // Get the view from viewpager_main.xml
        setContentView(R.layout.viewpager_main);

        View.OnClickListener handler = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                switch (view.getId()) {

                    // case R.id.buttonShareTextUrl :
                    //    shareTextUrl();
                    //     break;

                    case R.id.buttonShareImage:
                        shareImage();
                        break;

                }
            }
        };

        // our buttons
        // findViewById(R.id.buttonShareTextUrl).setOnClickListener(handler);
        findViewById(R.id.buttonShareImage).setOnClickListener(handler);

        // Generate sample data
        rank = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        country = new String[]{"China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan"};

        population = new String[]{"1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000"};

        flag = new int[]{R.drawable.china, R.drawable.india,
                R.drawable.unitedstates, R.drawable.indonesia,
                R.drawable.brazil, R.drawable.pakistan, R.drawable.nigeria,
                R.drawable.bangladesh, R.drawable.russia, R.drawable.japan};

        //Setting default values

        popRank = rank[0].toString();
        countryName = country[0].toString();

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, rank, country, population, flag);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                popRank = rank[arg0].toString();
                countryName = country[arg0].toString();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    private void shareImage() {

        Intent imageShare = new Intent(Intent.ACTION_SEND);

        imageShare.setType("image/*");

        String imagePath = Environment.getExternalStorageDirectory() + "/myImage.png";

        File imageFileToShare = new File(imagePath);

        Uri uri = Uri.fromFile(imageFileToShare);

        imageShare.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(imageShare, "Share Image!"));

    }


    private void shareTextUrl() {

        Intent textShare = new Intent(Intent.ACTION_SEND);
        textShare.setType("text/plain");
        textShare.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        textShare.putExtra(Intent.EXTRA_SUBJECT, popRank);
        textShare.putExtra(Intent.EXTRA_TEXT, countryName);

        startActivity(Intent.createChooser(textShare, "Share Link!"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:
                TextView txtcountry;

                txtcountry = (TextView) findViewById(R.id.country);

                txtcountry.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.font_size));

                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.buttonShareTextUrl:
                shareTextUrl();
                break;

            case R.id.feed_back:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "girish.harthikote@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(intent, "Send Email"));
                break;

            case R.id.rateApp:
                String myUrl = "https://play.google.com/store/apps/details?id=smartsilencer";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
                break;

            case R.id.btn_star:

                Toast.makeText(MainActivity.this,"Favorite Added!",Toast.LENGTH_SHORT).show();


            default:
                break;
        }

        return true;
    }

}
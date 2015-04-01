package com.quotes.studiostore.multipleactivities;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.quotes.studiostore.multipleactivities.stab.SlidingTabLayout;


public class MainActivity extends FragmentActivity {


   // String[] AndroidOS = new String[] { "Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream SandWich","Jelly Bean","KitKat" };
   // String[] Version = new String[]{"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),MainActivity.this));

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

        slidingTabLayout.setViewPager(viewPager);


//        // initiate the listadapter
//
//        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,
//
//                android.R.layout.simple_list_item_1, AndroidOS);
//
//        // assign the list adapter
//        setListAdapter(myAdapter);
    }

    // when an item of the list is clicked

//    @Override
//    protected void onListItemClick(ListView list, View view, int position, long id) {
//        super.onListItemClick(list, view, position, id);
//
//        String selectedItem = (String) getListView().getItemAtPosition(position);
//
//        String item = list.getItemAtPosition(position).toString();
//
//        Toast.makeText(this, "You selected : " + item, Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(this,MainActivity2Activity.class );
//        intent.putExtra("id",position);
//        startActivity(intent);
//    }


   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

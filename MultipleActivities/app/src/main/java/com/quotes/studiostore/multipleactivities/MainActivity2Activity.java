package com.quotes.studiostore.multipleactivities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    String[] AndroidOS = new String[] { "Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream SandWich","Jelly Bean","KitKat" };
    String[] Version = new String[]{"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4"};

    int position =0;
    String idString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        position = getIntent().getIntExtra("id",0);

        idString = ""+ position;

        TextView t2 = (TextView)findViewById(R.id.position);
        t2.setText(idString);

        String item = AndroidOS[position];

        TextView t = (TextView)findViewById(R.id.txtView);
        t.setText(item);
    }

    public void ButtonOnClick(View v) {
        switch (v.getId()) {
            case R.id.prev:
                if(position==0)
                {
                    position = 8;
                }
                else
                {
                    position = position-1;
                }

              String   idString1 = ""+ position;

                TextView t2 = (TextView)findViewById(R.id.position);
                t2.setText(idString1);

                String item = AndroidOS[position];

                TextView t = (TextView)findViewById(R.id.txtView);
                t.setText(item);
                break;

            case R.id.next:
                if(position==8)
                {
                    position = 0;
                }
                else
                {
                    position = position+1;
                }
                String idString2 = ""+ position;

                TextView tt = (TextView)findViewById(R.id.position);
                tt.setText(idString2);

                String item2 = AndroidOS[position];

                TextView ttt = (TextView)findViewById(R.id.txtView);
                ttt.setText(item2);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

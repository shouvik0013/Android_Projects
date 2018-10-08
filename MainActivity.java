package com.example.shouvikmandal.homework2;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomArrayAdapter customArrayAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public int images[] = {
            R.drawable.bear, R.drawable.bird, R.drawable.cat, R.drawable.cow,
            R.drawable.dolphin, R.drawable.fish, R.drawable.fox, R.drawable.horse
    };

    public String [] animalNames = {
            "Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        customArrayAdapter = new CustomArrayAdapter(this);
        listView.setAdapter(customArrayAdapter);

        /*drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }












    public class CustomArrayAdapter extends BaseAdapter {

        Context context;
        LayoutInflater layoutInflater;

        // Constructor
        public CustomArrayAdapter(Context context) {
            this.context = context;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = layoutInflater.inflate(R.layout.row_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.row_img);

            TextView textView = (TextView) view.findViewById(R.id.textView);

            textView.setText(animalNames[i]);

            imageView.setImageResource(images[i]);

            return view;
        }
    }



}

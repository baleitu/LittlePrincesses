package com.example.michelle.littleprincesses.ui.buyer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.michelle.littleprincesses.R;

import java.util.ArrayList;
import java.util.List;


public class ChooseRestaurant extends Activity {

    private Activity activity;
    private Button seeMenu;
    private Button exit;

    private List<String> restaurants = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_buyer_activity_choose_restaurant);

        activity = this;
        seeMenu = (Button)findViewById(R.id.choose_restaurant_seeMenuButton);
        exit = (Button)findViewById(R.id.choose_restaurant_exitButton);

        seeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, OrderDishes.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, BuyerWelcome.class);
                startActivity(intent);
            }
        });

        populateRestaurantList();
        populateListView();

    }

    private void populateRestaurantList(){
        restaurants.add("HorseLord's");
        restaurants.add("TokyoExpress");
        restaurants.add("LittleAsia");
    }

    private void populateListView(){
        ArrayAdapter<String> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.choose_restaurant_restaurantList);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<String> {
        public MyListAdapter() {
            super(ChooseRestaurant.this, R.layout.ui_buyer_item, restaurants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Make sure that we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.ui_buyer_item, parent, false);
            }

            // Find the car to work with
            final String curRestaurant = restaurants.get(position);

            // Fill the view
            CheckBox checkbox = (CheckBox) itemView.findViewById(R.id.msyCheckBox);
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            Button seeImage = (Button)itemView.findViewById(R.id.msy_item_see_image);
            seeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseRestaurant.this, BuyerDisplay.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("curRestaurant", curRestaurant);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            // Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.msyItemText);
            makeText.setText(curRestaurant);

            return itemView;
            //return super.getView(position, convertView,parent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_restaurant, menu);
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

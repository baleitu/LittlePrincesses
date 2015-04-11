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


public class OrderDishes extends Activity {

    private Activity activity;
    private Button confirmOrder;
    private Button exit;

    private List<String> menu = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_buyer_activity_order_dishes);

        activity = this;
        confirmOrder = (Button)findViewById(R.id.orderdishes_submitOrder);
        exit = (Button)findViewById(R.id.order_dishes_exitButton);

        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ConfirmPage.class);
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

        populateMenu();
        populateListView();
    }

    private void populateMenu(){
        menu.add("Beef Noodle");
        menu.add("Seafood with rice");
    }

    private void populateListView(){
        ArrayAdapter<String> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.order_dishes_menu);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<String> {
        public MyListAdapter() {
            super(OrderDishes.this, R.layout.ui_buyer_item, menu);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Make sure that we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.ui_buyer_item, parent, false);
            }

            // Find the car to work with
            String curRestaurant = menu.get(position);

            // Fill the view
            CheckBox checkbox = (CheckBox) itemView.findViewById(R.id.msyCheckBox);
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

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
        getMenuInflater().inflate(R.menu.menu_order_dishes, menu);
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

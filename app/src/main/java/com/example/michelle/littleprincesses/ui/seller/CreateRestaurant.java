package com.example.michelle.littleprincesses.ui.seller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.michelle.littleprincesses.R;


public class CreateRestaurant extends Activity {

    TextView titleCreateRestaurant;
    TextView infoCreateRestaurant;
    TextView titleNameCreateRestaurant;
    TextView titleAddressCreateRestaurant;
    TextView titleCategoryCreateRestaurant;
    EditText nameCreateRestaurant;
    EditText addressCreateRestaurant;
    EditText categoryCreateRestaurant;
    Button submitCreateRestaurant;
    Button cancelCreateRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seller_activity_create_restaurant);

        titleCreateRestaurant = (TextView)findViewById(R.id.title_create_restaurant);
        infoCreateRestaurant = (TextView)findViewById(R.id.info_create_restaurant);
        titleNameCreateRestaurant = (TextView)findViewById(R.id.title_name_create_restaurant);
        titleAddressCreateRestaurant = (TextView)findViewById(R.id.title_address_create_restaurant);
        titleCategoryCreateRestaurant = (TextView)findViewById(R.id.title_category_create_restaurant);

        nameCreateRestaurant = (EditText) findViewById(R.id.name_create_restaurant);
        addressCreateRestaurant = (EditText) findViewById(R.id.address_create_restaurant);
        categoryCreateRestaurant = (EditText) findViewById(R.id.category_create_restaurant);
        submitCreateRestaurant = (Button) findViewById(R.id.submit_create_restaurant);
        cancelCreateRestaurant = (Button) findViewById(R.id.cancel_create_restaurant);

        submitCreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(CreateRestaurant.this, CreateRestaurant.class);
                startActivity(intent);*/

            }
        });

        cancelCreateRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CreateRestaurant.this, MainActivitySeller.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_restaurant, menu);
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

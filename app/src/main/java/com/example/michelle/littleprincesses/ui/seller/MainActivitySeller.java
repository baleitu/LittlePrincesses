package com.example.michelle.littleprincesses.ui.seller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michelle.littleprincesses.R;
import com.example.michelle.littleprincesses.ui.login.Login;


public class MainActivitySeller extends Activity {

    TextView titleMainActivitySeller;
    Button createRestaurant;
    Button createMenu;
    Button updateMenu;
    Button deleteMenu;
    Button updateOrderStatus;
    Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seller_activity_main_activity_seller);

        titleMainActivitySeller = (TextView)findViewById(R.id.title_main_activity_seller);
        createRestaurant = (Button)findViewById(R.id.create_restaurant);
        createMenu = (Button)findViewById(R.id.create_menu);
        updateMenu = (Button)findViewById(R.id.update_menu);
        deleteMenu = (Button)findViewById(R.id.delete_menu);
        updateOrderStatus = (Button)findViewById(R.id.update_order_status);
        logOut = (Button)findViewById(R.id.seller_welcome_logout);

        createRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivitySeller.this, CreateRestaurant.class);
                startActivity(intent);

            }
        });

        createMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivitySeller.this, CreateMenu.class);
                startActivity(intent);

            }
        });

        updateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivitySeller.this, UpdateMenuList.class);
                startActivity(intent);

            }
        });

        deleteMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivitySeller.this, DeleteMenu.class);
                startActivity(intent);

            }
        });

        updateOrderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivitySeller.this, UpdateOrderStatus.class);
                startActivity(intent);

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySeller.this, Login.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_seller, menu);
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

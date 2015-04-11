package com.example.michelle.littleprincesses.ui.seller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.example.michelle.littleprincesses.R;

public class CreateMenu extends Activity {

    TextView titleCreateMenu;
    TextView infoCreateMenu;
    TextView titleNameCreateMenu;
    TextView titleIntroCreateMenu;
    TextView titlePriceCreateMenu;
    EditText nameCreateMenu;
    EditText introCreateMenu;
    EditText priceCreateMenu;
    Button submitCreateMenu;
    Button cancelCreateMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seller_activity_create_menu);

        titleCreateMenu = (TextView)findViewById(R.id.title_create_menu);
        infoCreateMenu = (TextView)findViewById(R.id.info_create_menu);
        titleNameCreateMenu = (TextView)findViewById(R.id.title_name_create_menu);
        titleIntroCreateMenu = (TextView)findViewById(R.id.title_intro_create_menu);
        titlePriceCreateMenu = (TextView)findViewById(R.id.title_price_create_menu);

        nameCreateMenu= (EditText) findViewById(R.id.name_create_menu);
        introCreateMenu = (EditText) findViewById(R.id.intro_create_menu);
        priceCreateMenu = (EditText) findViewById(R.id.price_create_menu);
        submitCreateMenu = (Button) findViewById(R.id.submit_create_menu);
        cancelCreateMenu = (Button) findViewById(R.id.cancel_create_menu);

        submitCreateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(CreateRestaurant.this, CreateRestaurant.class);
                startActivity(intent);*/

            }
        });

        cancelCreateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CreateMenu.this, MainActivitySeller.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_menu, menu);
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

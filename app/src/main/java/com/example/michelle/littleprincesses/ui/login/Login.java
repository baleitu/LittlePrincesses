package com.example.michelle.littleprincesses.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.michelle.littleprincesses.R;
import com.example.michelle.littleprincesses.ui.buyer.BuyerWelcome;
import com.example.michelle.littleprincesses.ui.seller.MainActivitySeller;


public class Login extends Activity {

    Button loginB;
    Button loginS;
    Button createB;
    Button createS;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login_activity_login);

        activity = this;

        loginB = (Button) findViewById(R.id.loginB);
        loginS = (Button) findViewById(R.id.loginS);
        createB = (Button) findViewById(R.id.BCreate);
        createS = (Button) findViewById(R.id.SCreate);

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, BuyerWelcome.class);
                startActivity(intent);

            }
        });

        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, BuyerWelcome.class);
                startActivity(intent);

            }
        });

        loginS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, MainActivitySeller.class);
                startActivity(intent);

            }
        });

        createS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, MainActivitySeller.class);
                startActivity(intent);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

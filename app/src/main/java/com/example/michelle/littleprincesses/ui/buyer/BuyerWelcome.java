package com.example.michelle.littleprincesses.ui.buyer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.michelle.littleprincesses.R;
import com.example.michelle.littleprincesses.ui.login.Login;


public class BuyerWelcome extends Activity {

    private Button toOrder;
    private Button toStatus;
    private Button logOut;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_buyer_activity_buyer_welcome);

        activity = this;
        toOrder = (Button)findViewById(R.id.welcome_order);
        toStatus = (Button)findViewById(R.id.welcome_status);
        logOut = (Button)findViewById(R.id.welcome_logout);

        toOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,ChooseRestaurant.class);
                startActivity(intent);
            }
        });

        toStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,OrderStatus.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,Login.class);
                startActivity(intent);
            }
        });
    }

}

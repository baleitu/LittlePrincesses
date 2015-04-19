package com.example.michelle.littleprincesses.ui.buyer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.michelle.littleprincesses.R;


public class BuyerDisplay extends Activity {

    private Activity activity;
    private Button returnButton;
    private TextView curRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_buyer_activity_buyer_display);

        activity = this;
        returnButton = (Button)findViewById(R.id.display_return);
        curRestaurant = (TextView)findViewById(R.id.display_restaurant_name);

        Bundle bundle = getIntent().getExtras();
        curRestaurant.setText(String.valueOf(bundle.getString("curRestaurant")));

        returnButton = (Button)findViewById(R.id.display_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ChooseRestaurant.class);
                startActivity(intent);
            }
        });

    }

}

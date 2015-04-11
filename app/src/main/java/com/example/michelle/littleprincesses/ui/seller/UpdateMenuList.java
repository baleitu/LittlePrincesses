package com.example.michelle.littleprincesses.ui.seller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.michelle.littleprincesses.R;
import com.example.michelle.littleprincesses.model.MenuInfo;

import java.util.ArrayList;
import java.util.List;

public class UpdateMenuList extends Activity {

    private List<MenuInfo> myMenus = new ArrayList<MenuInfo>();

    Button submitUpdateMenuList;
    Button cancelUpdateMenuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_seller_activity_update_menu_list);

        populateCarList();
        populateListView();

        submitUpdateMenuList = (Button) findViewById(R.id.submit_update_menu_list);
        cancelUpdateMenuList = (Button) findViewById(R.id.cancel_update_menu_list);

        submitUpdateMenuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UpdateMenuList.this, UpdateMenu.class);
                startActivity(intent);

            }
        });

        cancelUpdateMenuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UpdateMenuList.this, MainActivitySeller.class);
                startActivity(intent);

            }
        });

    }


    // This method is used to populate the car list
    private void populateCarList(){
        myMenus.add(new MenuInfo("Seafood Noodle", "good", 10));
        myMenus.add(new MenuInfo("Chicken Rice", "good", 10));
        myMenus.add(new MenuInfo("Beaf Noodle", "good", 10));
    }

    private void populateListView(){
        ArrayAdapter<MenuInfo> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.carLisView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<MenuInfo>{
        public MyListAdapter(){
            super(UpdateMenuList.this, R.layout.ui_seller_item, myMenus);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            // Make sure that we have a view to work with (may have been given null)
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.ui_seller_item,parent, false);
            }

            // Find the car to work with
            MenuInfo currentMenu = myMenus.get(position);



            // Fill the view
            CheckBox checkbox = (CheckBox) itemView.findViewById(R.id.select1);
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            // Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.make1);
            makeText.setText(currentMenu.getName());

            return itemView;
            //return super.getView(position, convertView,parent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_menu_list, menu);
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


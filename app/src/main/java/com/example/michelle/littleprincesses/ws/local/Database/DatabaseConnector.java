package com.example.michelle.littleprincesses.ws.local.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.michelle.littleprincesses.entities.BuyerLogin;
import com.example.michelle.littleprincesses.entities.Seller;
import com.example.michelle.littleprincesses.entities.SellerLogin;
import com.example.michelle.littleprincesses.entities.SellerMenu;
import com.example.michelle.littleprincesses.entities.SellerRest;
import java.util.ArrayList;


/**
 * Created by Michelle on 4/7/15.
 */
public class DatabaseConnector {

    // database name
    private static final String DATABASE_NAME = "StudentsRecord";
    private static final String TABLE_ACCOUNT = "UserAccount";
    private static final String TABLE_SELLER = "Seller";
    private static final String TABLE_MENU = "Menu";
    private SQLiteDatabase database; // database object
    private DatabaseOpenHelper databaseOpenHelper; // database helper

    private static final String[] ACCOUNT_COLUMN = {"email","password"};


    // public constructor for DatabaseConnector
    public DatabaseConnector(Context context)
    {
        // create a new DatabaseOpenHelper
        databaseOpenHelper =
                new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
    } // end DatabaseConnector constructor

    // open the database connection
    public void open() throws SQLException
    {
        // create or open a database for reading/writing
        database = databaseOpenHelper.getWritableDatabase();
    } // end method open

    // close the database connection
    public void close()
    {
        if (database != null)
            database.close(); // close the database connection
    } // end method close

    public void insertBuyer(BuyerLogin buyer) {
        ContentValues values = new ContentValues();
        values.put("email", buyer.getEmail());
        values.put("password", buyer.getPW());

        open();
        database.execSQL("PRAGMA foreign_keys = ON;");
        database.insert(TABLE_ACCOUNT, null, values);
        close();
    }

    public void insertSeller(SellerLogin seller) {
        ContentValues values = new ContentValues();
        values.put("email", seller.getEmail());
        values.put("password", seller.getPW());

        open();
        database.execSQL("PRAGMA foreign_keys = ON;");
        database.insert(TABLE_ACCOUNT, null, values);
        close();
    }

    public void insertRestaurant(SellerRest res) {

        ContentValues values = new ContentValues();
        values.put("restName", res.getResName());
        values.put("location", res.getLocation());
        values.put("description", res.getDescription());
        values.put("sellerEmail", res.getEmail());

        open();
        database.execSQL("PRAGMA foreign_keys = ON;");
        database.insert(TABLE_SELLER, null, values);
        close();

    }

    public void insertMenu(SellerMenu menu) {

        ContentValues values = new ContentValues();
        values.put("dishName", menu.getDishName());
        values.put("price", menu.getPrice());

        open();

        String query = "SELECT _id from " + TABLE_SELLER + " where sellerEmail=" + menu.getEmail();
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {

                values.put("resID", cursor.getInt(0));

            }while (cursor.moveToNext());
        }

        database.execSQL("PRAGMA foreign_keys = ON;");
        database.insert(TABLE_MENU, null, values);
        close();
    }

    public void updateMenu(SellerMenu menu) {

        ContentValues values = new ContentValues();
        values.put("dishName", menu.getDishName());
        values.put("price", menu.getPrice());
        int resID = 0;

        open();

        String query = "SELECT _id from " + TABLE_SELLER + " where sellerEmail='" + menu.getEmail() + "'";
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                resID = cursor.getInt(0);
                values.put("resID", resID);

            }while (cursor.moveToNext());
        }

        database.execSQL("PRAGMA foreign_keys = ON;");
        database.update(TABLE_MENU, values, "resID="+resID, null);
        close();

    }

    public void deleteMenu(SellerMenu menu) {

        ContentValues values = new ContentValues();
        values.put("dishName", menu.getDishName());
        values.put("price", menu.getPrice());
        int resID = 0;

        open();

        String query = "SELECT _id from " + TABLE_SELLER + " where sellerEmail='" + menu.getEmail() + "'";
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                resID = cursor.getInt(0);
                values.put("resID", resID);

            }while (cursor.moveToNext());
        }

        database.execSQL("PRAGMA foreign_keys = ON;");
        database.delete(TABLE_MENU, "resID=" + resID + " and dishName='" + menu.getDishName() + "'", null);
        close();
    }

    public ArrayList<SellerRest> getRestaurants(){
        open();
        ArrayList<SellerRest> restaurants = new ArrayList<>();
        String query = "select * from " + TABLE_SELLER;
        Cursor cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {

                System.out.println("get into the while");
                Seller res = new Seller();
                res.setResName(cursor.getString(1));
                res.setLocation(cursor.getString(3));
                res.setDescription(cursor.getString(4));
                res.setEmail(cursor.getString(5));
                restaurants.add(res);
            } while (cursor.moveToNext());
        }

        close();
        return  restaurants;
    }

    public ArrayList<SellerMenu> getMenus(SellerRest restaurant) {
        open();

        ArrayList<SellerMenu> menus = new ArrayList<>();

        int resID = 0;

        String query = "SELECT _id from " + TABLE_SELLER + " where sellerEmail='" + restaurant.getEmail() + "'";
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                resID = cursor.getInt(0);

            }while (cursor.moveToNext());
        }

        query = "select * from " + TABLE_MENU + " where resID=" + resID;
        cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {

                System.out.println("get into the while");
                Seller res = new Seller();
                res.setDishName(cursor.getString(1));
                res.setPrice(Double.parseDouble(cursor.getString(3)));
                menus.add(res);
            } while (cursor.moveToNext());
        }

        close();
        return  menus;
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper
    {
        // public constructor
        public DatabaseOpenHelper(Context context, String name,
                                  SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        } // end DatabaseOpenHelper constructor

        // creates the contacts table when the database is created
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            // query to create a new table named contacts
            String createQuery = "CREATE TABLE " + TABLE_ACCOUNT +
                    "(email TEXT,password TEXT);";
            db.execSQL(createQuery); // execute the query

            createQuery = "CREATE TABLE " + TABLE_SELLER +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT,restName TEXT,restPic BLOB,location TEXT,description TEXT,"
                    +"sellerEmail TEXT,FOREIGN KEY(sellerEmail) REFERENCES "+ TABLE_ACCOUNT + "(email) ON DELETE CASCADE);";
            db.execSQL(createQuery);

            createQuery = "CREATE TABLE " + TABLE_MENU +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT,dishName TEXT,restPic BLOB,price double,"
                    +"resID INTEGER,FOREIGN KEY(resID) REFERENCES "+ TABLE_SELLER + "(_id) ON DELETE CASCADE);";
            db.execSQL(createQuery);

        } // end method onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
        } // end method onUpgrade
    } // end class DatabaseOpenHelper


}

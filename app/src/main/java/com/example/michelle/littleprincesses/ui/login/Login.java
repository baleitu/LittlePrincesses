package com.example.michelle.littleprincesses.ui.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.michelle.littleprincesses.R;
import com.example.michelle.littleprincesses.exception.AccountAlreadyExistException;
import com.example.michelle.littleprincesses.exception.AccountNotFoundException;
import com.example.michelle.littleprincesses.exception.ExceptionHandler;
import com.example.michelle.littleprincesses.ui.buyer.BuyerWelcome;
import com.example.michelle.littleprincesses.ui.seller.MainActivitySeller;


public class Login extends Activity {

    private Button loginBuyer;
    private Button loginSeller;
    private Button createBuyer;
    private Button createSeller;
    private EditText account;
    private EditText password;
    private Activity activity;
    private String accountSearch;
    private String passwordSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login_activity_login);

        activity = this;
        loginBuyer = (Button) findViewById(R.id.loginB);
        loginSeller = (Button) findViewById(R.id.loginS);
        createBuyer = (Button) findViewById(R.id.BCreate);
        createSeller = (Button) findViewById(R.id.SCreate);
        account = (EditText)findViewById(R.id.accountInput);
        password = (EditText)findViewById(R.id.passwordInput);

        accountSearch = account.toString();
        passwordSearch = password.toString();


        loginBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sellerPermitted(accountSearch,passwordSearch)) {
                    Intent intent = new Intent(activity, BuyerWelcome.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("account",accountSearch);
                    bundle.putString("password",passwordSearch);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        createBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBuyerExist(accountSearch,passwordSearch)){
                    AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                    alertDialog.setTitle("Message:");
                    alertDialog.setMessage("New account created!\nplease use your new account and " +
                            "password to login!");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alertDialog.show();

                }
            }
        });

        loginSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(buyerPermitted(accountSearch,passwordSearch)){

                    Intent intent = new Intent(activity, MainActivitySeller.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("account",accountSearch);
                    bundle.putString("password",passwordSearch);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        createSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkSellerExist(accountSearch,passwordSearch)){
                    AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                    alertDialog.setTitle("Message:");
                    alertDialog.setMessage("New account created!\nplease use your new account and " +
                            "password to login!");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alertDialog.show();
                }

            }
        });
    }

    private boolean sellerPermitted(String accountSearch, String passwordSearch){

        boolean permission = true;

        try {
            // Read From DB here ...
        }catch(Exception e){
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            exceptionHandler.writeLog(e,activity);
            if (e.getClass().equals(AccountNotFoundException.class)){
                 exceptionHandler.fixAccountNotFoundException();
            }else{
                exceptionHandler.fixGeneral();
            }
        }

        return permission;
    }

    private boolean buyerPermitted(String accountSearch, String passwordSearch){

        boolean permission = true;

        try {
            // Read From DB here ...
        }catch(Exception e){
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            exceptionHandler.writeLog(e,activity);
            if (e.getClass().equals(AccountNotFoundException.class)){
                exceptionHandler.fixAccountNotFoundException();
            }else{
                exceptionHandler.fixGeneral();
            }
        }

        return permission;
    }

    private boolean checkBuyerExist(String accountSearch, String passwordSearch){

        boolean valid = true;

        try {
            // Read From DB here ...
        }catch(Exception e){
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            exceptionHandler.writeLog(e,activity);
            if (e.getClass().equals(AccountAlreadyExistException.class)){
                exceptionHandler.fixAccountAlreadyExistException();
            }else{
                exceptionHandler.fixGeneral();
            }
        }

        return valid;
    }

    private boolean checkSellerExist(String accountSearch, String passwordSearch){

        boolean valid = true;

        try {
            // Read From DB here ...
        }catch(Exception e){
            ExceptionHandler exceptionHandler = new ExceptionHandler();
            exceptionHandler.writeLog(e,activity);
            if (e.getClass().equals(AccountAlreadyExistException.class)){
                exceptionHandler.fixAccountAlreadyExistException();
            }else{
                exceptionHandler.fixGeneral();
            }
        }

        return valid;
    }

}

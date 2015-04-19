package com.example.michelle.littleprincesses.exception;

import android.content.Context;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shuoyao on 4/11/15.
 */
public class ExceptionHandler {
    // This method is used to write log
    public void writeLog(Exception exception, Context context){
        try {

            SimpleDateFormat format = new SimpleDateFormat();
            String timeStamp = format.format(new Date());

            StringBuilder writeString = new StringBuilder();

            writeString.append(timeStamp);
            writeString.append(": ");
            writeString.append(exception.getMessage());
            writeString.append("\n");

            OutputStreamWriter write = new OutputStreamWriter(context.openFileOutput("Log.txt", 0));

            write.write(writeString.toString());
            write.close();

        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }

    public void fixAccountNotFoundException(){

    }

    public void fixAccountAlreadyExistException(){

    }

    // This method is used to fix general exceptions
    public void fixGeneral(){
        System.exit(0);
    }
}
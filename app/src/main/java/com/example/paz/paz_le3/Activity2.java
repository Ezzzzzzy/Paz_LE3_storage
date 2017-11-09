package com.example.paz.paz_le3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {
    EditText filename2;
    TextView message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        filename2 = (EditText)findViewById(R.id.filename);
        message2 = (TextView) findViewById(R.id.message);
    }

    public void LoadPreferences(View view){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String  message1 = sharedPreferences.getString("message", "") ;
        message2.setText(message1);
    }

    public void LoadStorage (View view) {
        FileInputStream fis;
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            String file = filename2.getText().toString()+".txt";
            fis = openFileInput(file);
            while((read =fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message2.setText(buffer.toString());
    }

    public void LoadIC(View view){
        String file = filename2.getText().toString()+".txt";
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(getCacheDir(), file));
            while((read =fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message2.setText(buffer.toString());
    }

    public void getEC(View view){
        StringBuffer buffer = new StringBuffer();
        String file = filename2.getText().toString()+".txt";
        int read = 0;
        try {
            FileInputStream fis = new FileInputStream(new File(getExternalCacheDir(), file));
            while((read =fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message2.setText(buffer.toString());
    }

    public void getES(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        String file = filename2.getText().toString()+".txt";
        try {
            FileInputStream fis = new FileInputStream(new File(getExternalFilesDir("temp"), file));
            while((read =fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        message2.setText(buffer.toString());
    }

    public void loadExternalPublic(View view){
        String file = filename2.getText().toString()+".txt";
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            FileInputStream fis = new FileInputStream(new File(dir, file));
            while((read = fis.read()) != -1){
                buffer.append((char) read);
            }
            message2.setText(buffer.toString());
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void back(View view){
        Intent sd=new Intent(this,Activity1.class);
        startActivity(sd);
    }




}

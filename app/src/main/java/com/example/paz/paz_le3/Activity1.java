package com.example.paz.paz_le3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity1 extends AppCompatActivity {
    EditText filename, message;
    FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        filename = (EditText)findViewById(R.id.filename);
        message = (EditText)findViewById(R.id.message);
    }

    public void sp(View view){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("message", message.getText().toString());
        editor.commit();
        Toast.makeText(this, "SAVED IN SHARED PREFERENCES!!!", Toast.LENGTH_LONG).show();
    }

    public void is(View view){
        String message1 = message.getText().toString();
        String filename1 = filename.getText().toString()+".txt";
        try {
            fos = openFileOutput(filename1, Context.MODE_PRIVATE);
            fos.write(message1.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "SAVED IN LOCAL STORAGE!!", Toast.LENGTH_LONG).show();
    }

    public void ic(View view){
        File folder = getCacheDir();
        String filename1 = filename.getText().toString()+".txt";
        File file = new File(folder, filename1);
        String message1 = message.getText().toString();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(message1.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "SAVED IN INTERNAL Cache!!", Toast.LENGTH_LONG).show();
    }

    public void ec(View view){
        File folder = getExternalCacheDir();
        String filename1 = filename.getText().toString()+".txt";
        File file = new File(folder, filename1);
        String message1 = message.getText().toString();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(message1.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "SAVED IN EXTERNAL Cache!!", Toast.LENGTH_LONG).show();
    }

    public void es(View view){
        File folder = getExternalFilesDir("temp");
        String filename1 = filename.getText().toString()+".txt";
        File file = new File(folder, filename1);
        String message1 = message.getText().toString();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(message1.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "SAVED IN EXTERNAL STORAGE!!", Toast.LENGTH_LONG).show();
    }
    public void eps(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String filename1 = filename.getText().toString()+".txt";
        File file = new File(folder, filename1);
        String message1 = message.getText().toString();
        writeData(file, message1);
        Toast.makeText(this, "Saved in Downloads Folder!", Toast.LENGTH_LONG).show();
    }

    public void writeData(File file, String message){
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void next(View view){
        Intent sd=new Intent(this,Activity2.class);
        startActivity(sd);
    }
}

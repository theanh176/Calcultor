package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activityLogin1 extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    public static final String EXTRA_MESSAGE="mystring";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        txtUsername = findViewById(R.id.editTextTextPersonName);
        txtPassword = findViewById(R.id.editTextTextPassword);

    }

    public void onClick_OK(View view){
        if(txtUsername.length()==0){
            if(txtPassword.length()==0){
                Toast toast = Toast.makeText(this, "Vui long nhap Username va Password", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                Toast toast = Toast.makeText(this, "Vui long nhap Username", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else if(txtPassword.length()==0){
            Toast toast = Toast.makeText(this, "Vui long nhap Password", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Intent messageIntent = new Intent(this,Activity_view.class);

            messageIntent.setData(Uri.parse("http://www.google.com.vn"));

            messageIntent.putExtra (EXTRA_MESSAGE, "Xin chao mung");

            startActivity(messageIntent);
        }
    }
    public void onClick_Cancel(View view){
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void onClick_Forgot(View view){
        if(txtUsername.length()==0){
            Toast toast = Toast.makeText(this, "Vui long nhap Username", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(this, "Toi cung quen", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
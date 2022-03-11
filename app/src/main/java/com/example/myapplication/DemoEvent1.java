package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DemoEvent1 extends AppCompatActivity {

    EditText txtName; // khoi bao doi tuong
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_event1);

        txtName=findViewById(R.id.editTextTextPersonName);// bind txtName với editTextTextPersonName
    }
    public void onClick_Button(View view) {
        // code xu ly
        //update noi dung edittext person name
        txtName.setText("Button Click");
    }
}
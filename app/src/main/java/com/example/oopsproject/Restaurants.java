package com.example.oopsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
    }
    public void r1(View view) {
        Intent intent= new Intent(this,Restaurant1.class);
        startActivity(intent);
    }
    public void r2(View view) {
        Intent intent= new Intent(this,Restaurant2.class);
        startActivity(intent);
    }
    public void r3(View view) {
        Intent intent= new Intent(this,Restaurant3.class);
        startActivity(intent);
    }
}

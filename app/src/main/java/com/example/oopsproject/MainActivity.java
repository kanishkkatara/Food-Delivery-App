package com.example.oopsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button resendCode;
    TextView verifyMsg;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
    public void search(View view){
        startActivity(new Intent(getApplicationContext(), Search.class));
    }
    public void order(View view){
        startActivity(new Intent(getApplicationContext(), Restaurants.class));
    }
    public void cart(View view){
        startActivity(new Intent(getApplicationContext(), PlaceOrder.class));
    }
    public void track(View view){

    }
}
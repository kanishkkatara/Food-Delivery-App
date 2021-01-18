package com.example.oopsproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceOrder extends AppCompatActivity {

    EditText address1;
    EditText email1;
    TextView cartTotal;
    Button paymentBtn, payLater;
    List<Orders> orders;
    DatabaseReference databaseOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        cartTotal = findViewById(R.id.cartTotal);
        databaseOrders = FirebaseDatabase.getInstance().getReference("orders");
        final Intent intent = getIntent();
        final String sum = intent.getStringExtra("total");
        cartTotal.setText("Your cart total is Rs " + sum);
        address1 = findViewById(R.id.address);
        email1 = findViewById(R.id.email);
        paymentBtn = findViewById(R.id.paymentBtn);
        payLater = findViewById(R.id.cod);
        orders = new ArrayList<>();

        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String sum = intent.getStringExtra("total");
                String rid = intent.getStringExtra("rid");
                String address = address1.getText().toString().trim();
                String email = email1.getText().toString().trim();
                if(!TextUtils.isEmpty(address)) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("rid", rid);
                    map.put("address", address);
                    map.put("email", email);
                    map.put("total", sum);
                    FirebaseDatabase.getInstance().getReference().child("orders").push().setValue(map);
                    Intent intent2= new Intent(PlaceOrder.this, test.class);
                    startActivity(intent2);
                    String[] TO_EMAILS = {email};
                    Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                    intent1.setData(Uri.parse("mailto:"));
                    intent1.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
                    intent1.putExtra(Intent.EXTRA_SUBJECT, "Order Placed");
                    intent1.putExtra(Intent.EXTRA_TEXT, "You order has been placed successfully. An amount of Rs "+sum+" have been deducted from your account. You will receive your order soon. Thank you");
                    Toast.makeText(PlaceOrder.this, "Click on send button to receive notification", Toast.LENGTH_SHORT).show();
                    startActivity(Intent.createChooser(intent1, "Choose an application"));
                }
            }
        });
        payLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String sum = intent.getStringExtra("total");
                String rid = intent.getStringExtra("rid");
                String address = address1.getText().toString().trim();
                String email = email1.getText().toString().trim();
                if(!TextUtils.isEmpty(address)) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("rid", rid);
                    map.put("address", address);
                    map.put("email", email);
                    map.put("total", sum);
                    FirebaseDatabase.getInstance().getReference().child("orders").push().setValue(map);
                    Intent intent2= new Intent(PlaceOrder.this, test.class);
                    startActivity(intent2);
                    String[] TO_EMAILS = {email};
                    Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                    intent1.setData(Uri.parse("mailto:"));
                    intent1.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
                    intent1.putExtra(Intent.EXTRA_SUBJECT, "Order Placed");
                    intent1.putExtra(Intent.EXTRA_TEXT, "You order has been placed successfully. Please pay a sum of Rs "+sum+" when you receive the order. Thank you");
                    Toast.makeText(PlaceOrder.this, "Click on send button to receive notification", Toast.LENGTH_SHORT).show();
                    startActivity(Intent.createChooser(intent1, "Choose an application"));
                }
            }
        });
    }
}

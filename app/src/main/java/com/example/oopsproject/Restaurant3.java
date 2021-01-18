package com.example.oopsproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Restaurant3 extends AppCompatActivity  {

    private Spinner spinner1,spinner2,spinner3;
    public int d1,d2,d3;
    public int i1, i2, i3;
    public int cost1,cost2,cost3,a,b,c;
    private int sum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant3);

        spinner1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(Restaurant3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(myAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int d1, long id) {

                if (d1==0) {
                    i1=0;

                }
                if (d1 == 1) {
                    i1=60;

                }
                if (d1 == 2) {
                    i1=120;

                }
                if (d1 == 3) {
                    i1=180;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2= new ArrayAdapter<String>(Restaurant3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names2));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int d2, long id) {

                if (d2==0) {
                    i2=0;

                }
                if (d2 == 1) {
                    i2=10;

                }
                if (d2 == 2) {

                    i2=20;

                }
                if (d2 == 3) {
                    i2=30;

                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3= new ArrayAdapter<String>(Restaurant3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names3));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(myAdapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int d3, long id) {

                if (d3==0) {
                    i3=0;
                }
                if (d3 == 1) {
                    i3=150;

                }
                if (d3 == 2) {
                    i3=300;

                }
                if (d3 == 3) {
                    i3=450;

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final TextView t1= (TextView) findViewById(R.id.textView9);

        Button cart=(Button) findViewById(R.id.amount);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum=i1+i2+i3;
                t1.setText("Your order total is Rs "+sum);
            }
        });

        Button order=(Button) findViewById(R.id.placeOrder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrder();
            }
        });

    }
    public void openOrder() {
        Intent intent= new Intent(this,PlaceOrder.class);
        String s1 = String.valueOf(sum);
        String s2 = "r3";
        intent.putExtra("total", s1);
        intent.putExtra("rid", s2);
        startActivity(intent);
    }
}

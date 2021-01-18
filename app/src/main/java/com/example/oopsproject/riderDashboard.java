package com.example.oopsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class riderDashboard extends AppCompatActivity {
    TextView orderId, rid, address;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("orders");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_dashboard);
        orderId = findViewById(R.id.orderId);
        rid = findViewById(R.id.rid);
        address = findViewById(R.id.address);
        update();

    }
    String str;
    public void update(){
        reference.limitToFirst(1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Information info = snapshot.getValue(Information.class);
                    String txt1 = info.getRid();
                    String txt2 = info.getAddress();
                    str = snapshot.getKey();
                    orderId.setText("Next Order: ID: "+str);
                    rid.setText("Restaurant: "+txt1);
                    address.setText("Address: "+txt2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void done(View view){
        reference.child(str).removeValue();
        update();
    }
}

package com.example.oopsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mRegisterBtn, mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView forgotTextLink;
    TextView riderLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.SignupBtn);
        mLoginBtn = findViewById(R.id.LoginBtn);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        forgotTextLink = findViewById(R.id.forgotPassword);
        riderLoginLink = findViewById(R.id.riderLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String email = mEmail.getText().toString().trim();
                    String password = mPassword.getText().toString().trim();
                    if(TextUtils.isEmpty(email)){
                        mEmail.setError("Please enter your Email ID");
                    }
                    if(TextUtils.isEmpty(password)){
                        mPassword.setError("Please enter your Password");
                        return;
                    }
                    if(password.length()< 8){
                        mPassword.setError("Please check your password");
                        return;
                    }
                    progressBar.setVisibility(View.VISIBLE);

                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                            else{
                                Toast.makeText(Login.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
                catch (Exception e){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Enter your email id.");
                passwordResetDialog.setView(resetMail);
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Reset link sent to your mail", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Error sending reset link"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }

    public void rLogin(View view){
        startActivity(new Intent(getApplicationContext(), riderLogin.class));
    }
    public void smLogin(View view){
        startActivity(new Intent(getApplicationContext(), smLogin.class));
    }
}
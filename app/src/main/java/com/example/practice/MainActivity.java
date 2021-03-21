package com.example.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText emailET;
    EditText passET;

    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference refrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        emailET = findViewById(R.id.signupName);
        passET = findViewById(R.id.signupPass);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        refrence = database.getReference("person");
    }

    public void SignUP(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();

        if (email.isEmpty()) {
            emailET.setError("Email Required");
        } else if (pass.isEmpty()) {
            passET.setError("Password Required");
        } else {
            signupuser(email, pass);
        }
    }

    private void signupuser(final String email, final String pass) {
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String key = auth.getCurrentUser().getUid();
                    Person person = new Person(email, pass);
                    refrence.child(key).setValue(person);

                    Intent inten = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(inten);
                } else {
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void LOGINbtn(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();

        if (email.isEmpty()) {
            emailET.setError("Email required");
        } else if (pass.isEmpty()) {
            passET.setError("Password required");
        } else {

            loginperson(email, pass);

        }

    }

    private void loginperson(String email, String pass) {
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
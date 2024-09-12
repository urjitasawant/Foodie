package com.example.foodie;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText emailField, passwordField;
    Button registerButton;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        registerButton = findViewById(R.id.registerButton);

        // Initialize SQLite database
        db = openOrCreateDatabase("FoodOrderingDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(email VARCHAR PRIMARY KEY, password VARCHAR);");

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        try {
            db.execSQL("INSERT INTO Users(email, password) VALUES(?, ?);", new Object[]{email, password});
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Registration failed. Email might already be used.", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

public class database extends AppCompatActivity {
    EditText place, id1;
    Button b1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);
        AppCompatCheckBox checkbox = findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    id1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    id1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        id1 = findViewById(R.id.places_id);
        String email = id1.getText().toString().trim();
        if (email.length() < 0)
        {
            id1.setError("Required");
        }
        place = findViewById(R.id.places);
        String pass = place.getText().toString().trim();
        if (pass.length() <0)
        {
            place.setError("Required");
        }
        b1 = findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity() {
        Intent i = new Intent(this, Registerpage.class);
        startActivity(i);
    }
    public void add(View view) {
        String places = place.getText().toString();
        String id = id1.getText().toString();
        background bg = new background(this);
        bg.execute(places, id);
    }
}
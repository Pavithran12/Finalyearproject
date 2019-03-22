package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] places = {"Gandhipuram", "Ukkadam", "Railway Station", "Uppilipalayam", "Anna Salai", "Lakshmi Mills", "Nava India", "ESSO bunk", "Peelamedu", "Krishnammal", "Varadharaja Mills", "Hopes college", "CMC", "CIT", "GRD", "PSGCAS", "SITRA"};
    String[] no ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
    String message;
    String src,des,tic;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button b1;
        b1 = findViewById(R.id.pay);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        Spinner spin = findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                src = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter source = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,places);
        spin.setAdapter(source);
        Spinner spin1 = findViewById(R.id.spinner2);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                des = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter destination = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,places);
        spin1.setAdapter(destination);
        Spinner spin3= findViewById(R.id.tickets);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tic = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter ticket = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,no);
        spin3.setAdapter(ticket);
    }
    public void openActivity() {
        message="Source :\t"+src+"\n"+"Destination :\t"+des+"\n"+"No.of.Tickets : \t"+tic;
        Intent i = new Intent(this, payment.class);
        i.putExtra("info", message);
        startActivity(i);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}

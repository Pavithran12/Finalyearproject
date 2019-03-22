package com.example.test;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registerpage extends AppCompatActivity {
    String spin="";
    String rg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        Button b1= findViewById(R.id.button1);
        final EditText et1 = findViewById(R.id.name);
        final EditText et2 = findViewById(R.id.age);
        final EditText et3 = findViewById(R.id.phone);
        final EditText et4 = findViewById(R.id.email);
        final EditText et5 = findViewById(R.id.password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String age = et2.getText().toString();
                String  phone=et3.getText().toString();
                String  email=et4.getText().toString();
                String  password=et5.getText().toString();
                fd bg = new fd(getApplicationContext());
                bg.execute(name, age,phone,email,password,rg,spin);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.male:
                if (checked) {
                    rg = "male";
                    break;
                }
            case R.id.female:
                if (checked) {
                    rg = "female";
                    break;
                }
            case R.id.others:
                if (checked) {
                    rg = "others";
                    break;
                }
        }
    }
    public void onRadioButtonClicked1(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.bp:
                if (checked) {
                    spin = "bus-pass";
                    break;
                }
            case R.id.t:
                if (checked) {
                    spin = "ticket";
                    break;
                }
        }

    }
}

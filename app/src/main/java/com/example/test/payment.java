package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class payment extends AppCompatActivity {
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("info");
        Button b1;
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
   }
    public void openActivity() {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("info", message);
        startActivity(i);
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.male:
                if (checked) {

                    break;
                }
            case R.id.female:
                if (checked) {

                    break;
                }
            case R.id.others:
                if (checked) {

                    break;
                }
        }
    }
}

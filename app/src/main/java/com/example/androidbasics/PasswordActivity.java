package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {
    TextView greetings;
    Button submit;
    EditText password;
    TextView wrongPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        greetings = findViewById(R.id.tv_greetings);
        password = findViewById(R.id.password);
        wrongPassword = findViewById(R.id.wrongPassword);
        submit = findViewById(R.id.button_submit);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("NAME");

            // Display the name in a TextView
            greetings.setText("Hello, " + name + "!");

            // Check the password
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(password.getText().toString().length() > 8){
                        Intent intent = new Intent(PasswordActivity.this, HomeActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        wrongPassword.setText("Password is less than 9 characters ");
                    }
                }
            });

        }
    }
}
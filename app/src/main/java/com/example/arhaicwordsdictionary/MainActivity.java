package com.example.arhaicwordsdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, register, guest;
    EditText username, password;
    int counter = 3;
    TextView attemptsLeft;
    TextView attemptsCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login_button);

        guest = (Button) findViewById(R.id.guest_button);
        register = (Button)findViewById(R.id.register_button);
        username = (EditText)findViewById(R.id.username_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);
        attemptsLeft = (TextView)findViewById(R.id.attempts_text_view);
        attemptsLeft.setVisibility(View.INVISIBLE);
        attemptsCounter = (TextView)findViewById(R.id.attempts_count_text_view);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),"Uspješna prijava",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Dictionary.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Neuspješna prijava",Toast.LENGTH_SHORT).show();

                    attemptsLeft.setVisibility(View.VISIBLE);
                    counter--;
                    attemptsCounter.setText(Integer.toString(counter));

                    if (counter == 0) {
                        login.setEnabled(false);
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        /*guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dictionary.addWord.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, Dictionary.class));
            }
        }); */

    }
}

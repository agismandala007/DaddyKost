package com.example.daddykost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomePemilikActivity extends AppCompatActivity {

    TextView helloUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pemilik);
        Bundle get = getIntent().getExtras();
        String user = get.getString("user");

        helloUser = findViewById(R.id.helo_username);
        helloUser.setText(user);
    }
}
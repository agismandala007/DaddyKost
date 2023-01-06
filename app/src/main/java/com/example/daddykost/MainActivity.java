package com.example.daddykost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);

        progressBar.setMax(100);
        progressBar.setScaleX(3f);

        progressAnimation();
    }

    public void progressAnimation(){
        ProggressBarAnimation animation = new ProggressBarAnimation(this, progressBar, 0f, 100f);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
}
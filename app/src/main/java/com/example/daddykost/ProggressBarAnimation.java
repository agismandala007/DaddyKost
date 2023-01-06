package com.example.daddykost;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProggressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private float from, to;

    public ProggressBarAnimation(Context context, ProgressBar progressBar, float from, float to){
        this.context = context;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t){
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int)value);

        if (value == to){
            context.startActivity(new Intent(context, HomeActivity.class));
        }
    }
}

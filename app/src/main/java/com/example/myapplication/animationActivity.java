package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class animationActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.browse);
        imageView.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == imageView.getId())
            fade();
    }

    private void fade() {
//      imageView.animate().alpha(1 - imageView.getAlpha()).setDuration(1500);
//      imageView.animate().rotationXBy(180).rotationYBy(180).setDuration(1000);
//      imageView.animate().scaleX(1.5f).setDuration(100);
//      imageView.animate().translationXBy(200).translationYBy(100).setDuration(800);
        imageView.animate().rotation(3600).alpha(0).setDuration(5000);
    }
}
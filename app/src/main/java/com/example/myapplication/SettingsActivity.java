package com.example.myapplication;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import java.net.URI;

public class SettingsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  //      final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.naziinbaroon);
  //      mediaPlayer.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        Button button = (Button)findViewById(R.id.button);
        Bundle extras = getIntent().getExtras();
        String name = "";
        name = extras.getString("name");
        EditText editText = findViewById(R.id.editText);
        editText.setText(name);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });


    }

}
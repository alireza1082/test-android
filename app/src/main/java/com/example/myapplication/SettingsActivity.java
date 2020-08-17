package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        String name = extras.getString("name");
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
        //editText.setText(name);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        final MenuItem menuItem = menu.add("cancel");
//        final MenuItem pow = menu.add("click");
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (menuItem.equals(item)) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
                return false;
            }
        });
        menu.add("click1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:09121231232"));
                intent.putExtra("sms_body" , "hello boy!");
                startActivity(intent);
                return false;
            }
        });
        SubMenu subMenu = menu.addSubMenu("subMenu");
        subMenu.add("dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:09226145636"));
                //call me:)
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
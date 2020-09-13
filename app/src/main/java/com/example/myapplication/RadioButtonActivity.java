package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = findViewById(R.id.radio);
        button = findViewById(R.id.radio_Button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == button.getId()){
            int ID = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(ID);
            if (radioButton != null) {
                Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                radioButton.setChecked(false);
            }
        }
    }
}
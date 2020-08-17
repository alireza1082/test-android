package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQ = 20;

    Car car = new Car(200 , 50 , "red");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.drive1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.km);
                int number = Integer.parseInt(editText.getText().toString());
                car.drive(number);
                TextView txv2 = findViewById(R.id.gas_txv);
                TextView txv1 = findViewById(R.id.distance_txv);
                txv1.setText("Distance : "+car.getDistance());
                txv2.setText("Gas : " + car.getGas());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ && resultCode == RESULT_OK){
            Toast.makeText(this , "its OK." , Toast.LENGTH_SHORT).show();
        }
        if (requestCode == REQ && resultCode == RESULT_CANCELED)
            Toast.makeText(this , "Not OK!" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean itemClick(MenuItem item){
        Toast.makeText(this , item.getTitle() , Toast.LENGTH_LONG).show();
        return true;
    }

    public boolean newPage(MenuItem item){
        Intent intent = new Intent(MainActivity.this , SettingsActivity.class);
        intent.putExtra("name" , "ali");
        startActivityForResult(intent , REQ);
        return true;
    }


    public void run() {
            while (true) {
                car.drive();
                TextView txv1 = findViewById(R.id.distance_txv);
                txv1.setText("Distance : "+car.getDistance());
                TextView txv2 = findViewById(R.id.gas_txv);
                txv2.setText("Gas : " + car.getGas());
            }
        }


    public void start(View view) {

    }

    public void break1(View view){
    }

    public void drive(View view){
        car.drive();
        TextView txv1 = findViewById(R.id.distance_txv);
        txv1.setText("Distance : "+car.getDistance());
        TextView txv2 = findViewById(R.id.gas_txv);
        txv2.setText("Gas : " + car.getGas());

    }
    public void gasoline(View view){
        car.gasoline();
        TextView txv2 = findViewById(R.id.gas_txv);
        txv2.setText("Gas : " + car.getGas());
    }

    public void decreamentspeed(View view){
        car.decreamentspeed();
        TextView txv2 = findViewById(R.id.speed);
        txv2.setText("speed : " + car.getSpeed());
    }

    public void icreamentspeed(View view){
        car.icreamentspeed();
        TextView txv2 = findViewById(R.id.speed);
        txv2.setText("speed : " + car.getSpeed());
    }
}

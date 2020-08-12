package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Car car = new Car(200 , 50 , "red");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        startActivity(intent);
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

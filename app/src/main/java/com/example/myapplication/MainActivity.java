package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

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
                try {
                    car.drive(Integer.parseInt(editText.getText().toString()));
                } catch (Exception e){
                    Toast.makeText( MainActivity.this , "field is empty" , Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
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
        menu.add("music").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this , musicActivity.class));
                return false;
            }
        });
        menu.add("dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this , dialog.class));
                return false;
            }
        });
        menu.add("List View").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this , ListViewActivity.class));
                return false;
            }
        });
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


    Timer timer = new Timer();
    public void start(View view) {
        try {
        timer.scheduleAtFixedRate(new TimerTask() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                car.drive();
                TextView txv1 = findViewById(R.id.distance_txv);
//                txv1.setText("Distance : "+ car.getDistance());
                TextView txv2 = findViewById(R.id.gas_txv);
//                 txv2.setText("Gas : " + car.getGas());
            }
        } , 0 , 1000);}catch (Exception e){
            e.printStackTrace();
        }
    }

    public void break1(View view){
        timer.cancel();
    }

    public void drive(View view){
        car.drive();
        TextView txv1 = findViewById(R.id.distance_txv);
        txv1.setText("Distance : "+ car.getDistance());
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

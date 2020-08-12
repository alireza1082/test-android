package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Car car = new Car(200 , 50 , "red");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    class thread extends Thread{
        @Override
        public void run() {
            while (true) {
                car.drive();
                TextView txv1 = findViewById(R.id.distance_txv);
                txv1.setText("Distance : "+car.getDistance());
                TextView txv2 = findViewById(R.id.gas_txv);
                txv2.setText("Gas : " + car.getGas());
            }
        }
    }

    thread t = new thread();

    public void start(View view) throws InterruptedException {
            t.start();
            thread.sleep(200);
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

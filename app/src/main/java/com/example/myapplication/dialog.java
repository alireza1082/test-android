package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void builder(View view) {
        if (view.getId() == R.id.click){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setTitle("wait!");
//        progressDialog.setMessage("oooo.!");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setButton(ProgressDialog.BUTTON2, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    progressDialog.dismiss();
                }
            });
            progressDialog.show();

            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (progressDialog.getProgress() < progressDialog.getMax())
                        progressDialog.incrementProgressBy(1);
                    else
                        progressDialog.dismiss();
                }
            }, 0 , 100);
        }
        if (view.getId() == R.id.click2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("hey").setMessage("do you want .. ?").setCancelable(false).setIcon(R.drawable.ic_launcher_foreground)
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            //startActivity(new Intent(dialog.this , MainActivity.class));
                        }
                    }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(dialog.this, "Canceled", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
        if (view.getId() == R.id.click3){
            final int[] num = {-1};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setSingleChoiceItems(new String[]{"ali", "reza", "mahdi"}, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    num[0] = which;
                }
            })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                public void onClick(DialogInterface dialog, int which) {
                            if (num [0] == 0)
                        Toast.makeText(dialog.this , "ali" , Toast.LENGTH_SHORT).show();
                    else if (num [0] == 1)
                        Toast.makeText(dialog.this , "reza" , Toast.LENGTH_SHORT).show();
                    else if (num [0] == 2)
                        Toast.makeText(dialog.this , "mahdi" , Toast.LENGTH_SHORT).show();
                }
            }).show();
        }

        if (view.getId() == R.id.click4){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("hey").setMultiChoiceItems(new String[]{"ali", "reza", "mahdi"}, new boolean[]{false , false , false} , null);
            builder.setPositiveButton("Yes" , null).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    }

    public void showDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog);
        dialog.show();
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    List<String> items;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        fillData();
        listView = findViewById(R.id.listView);
        showData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this , items.get(position) , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showData() {
        adapter = new ArrayAdapter<String>(ListViewActivity.this , android.R.layout.simple_list_item_1 , items);
        listView.setAdapter(adapter);
    }

    private void fillData() {
        items = new ArrayList<>();
        items.add("Tehran");
        items.add("Karaj");
        items.add("Alborz");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("add item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                items.add("new item");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        menu.add("remove item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (items.size() == 0)
                    return false;
                items.remove(items.size() - 1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}


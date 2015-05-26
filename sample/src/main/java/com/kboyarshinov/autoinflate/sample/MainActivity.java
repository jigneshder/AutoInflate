package com.kboyarshinov.autoinflate.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int LIST_SIZE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.sample_listview);
        List<String> data = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            data.add(String.format("Item #%d", i));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_main_item_layout, data);
        listView.setAdapter(adapter);
    }
}

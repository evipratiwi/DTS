package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //buat object penampung data itemlist tipe arrayList
    private ArrayList<String> ListItem = new ArrayList<>();
    private ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //isi data
        ListItem.add("Banjarmasin");
        ListItem.add("Banjarbaru");
        ListItem.add("Martapura");
        ListItem.add("Tapin");
        ListItem.add("HSS");
        ListItem.add("HST");
        ListItem.add("HSU");
        ListItem.add("Tabalong");
        ListItem.add("Batu Licin");
        ListItem.add("Kotabaru");
        ListItem.add("Barito Kuala");

        // hubungan object
        ListView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, ListItem);

        //set adapter
        ListView.setAdapter(adapter);

        //add listern and handling event
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "Kamu memilih : " + ListItem.get(i);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

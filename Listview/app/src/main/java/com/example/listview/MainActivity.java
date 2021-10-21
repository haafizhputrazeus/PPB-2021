package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public String game[]={"Valorant","Rocket League","FIFA 2021","Point Blank","GTA V","CSGO","PES 2021","Ayo Dance","PUBG"};

    Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdata);
        combo=(Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item,game);
        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}
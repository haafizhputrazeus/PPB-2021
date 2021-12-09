package com.example.projek7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ListView listView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView(listView)findviewById(R.id.listdata);

        tampilkanBarang("");
    }

    private void tampilkanBarang() {
        class tampilkanbarang extends AsyncTask<Void,Void,String>
        {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    bacadatakelist(s);
                }
            }
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url=new URL(s);

                    StringBuilder sb= new StringBuilder();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));

                    String json;
                    while ((json=bufferedReader.readLine()) !=null)
                    {
                        sb.append(json+"\n");
                    }
                    return sb.toString().trim();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }
        }
    }

    private void bacadatakelist(String json) {
        JSONArray jsonArray=new JSONArray(json);
        String stok[]=new String[jsonArray.length()];
        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject obj=jsonArray.getJSONObject(i);
            stok[i]=obj.getString(name "kode")+" "
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,stok);
        listView.setAdapter(arrayAdapter);
    }
}
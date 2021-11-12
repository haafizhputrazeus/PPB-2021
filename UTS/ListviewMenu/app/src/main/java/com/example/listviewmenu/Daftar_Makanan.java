package com.example.listviewmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Locale;

public class Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Editcari;
    ListViewAdapterCall adapter;
    ArrayList<Adaptormenu> arraylist = new ArrayList<Adaptormenu>();

    int[] Gambar;
    String[] NamaBurger;
    String[] HargaBurger;
    String[] Deskripsi;


    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Editcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_3patty,
                R.mipmap.b_2pattypremi,
                R.mipmap.c_singlepatty,
                R.mipmap.d_maddog,
                R.mipmap.e_papa};

        NamaBurger 	= new String[]{
                "Burger Triple Patty",
                "Burger Bomb",
                "Burger Single Patty",
                "Burger Maddog",
                "Burger Papa"};

        HargaBurger 	= new String[]{
                "Rp. 27.000",
                "Rp. 45.000",
                "Rp. 15.000",
                "Rp. 32.000",
                "Rp. 25.000"};

        Deskripsi 	= new String[]{
                "Tripple Patty burger adalah burger dengan tiga tumpuk patty daging, dan sayuran segar, dibalur saus keju yang lumer",

                "Bomb Burger adalah burger dengan 2 tumpuk patty daging premium, dan juga di lapisi keju red cheddar disetiap daginhnya",

                "Singgle Patty burger adalah burger dengan patty daging, dan sayuran segar, dibalur saus keju yang lumer",

                "Maddog Burger adalah burger dengan single patty premium dilapisi dengan keju red cheddar, dengan ekstra sosis didalamnya, dan sayuran segar",

                "Papa Burger adalah burger dengan single patty premium dilapisi dengan keju red cheddar, dengan caramel saus, dan sayur segar "};




        for (int i = 0; i < NamaBurger.length; i++)
        {
            Adaptormenu wp = new Adaptormenu(NamaBurger[i], HargaBurger[i], Deskripsi[i], Gambar[i] );
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Editcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Editcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

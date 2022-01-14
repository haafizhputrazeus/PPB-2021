package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Makanan extends Activity {
    String HargaBurger, NamaBurger, Deskripsi;
    int Gambar;
    int position;
    TextView tvHargaBurger, tvNamaBurger, tvDeskripsi;
    ImageView ImgGembar;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        tvHargaBurger	    = (TextView)findViewById(R.id.textView1);
        tvNamaBurger		= (TextView)findViewById(R.id.textView2);
        tvDeskripsi		    = (TextView)findViewById(R.id.textView3);
        ImgGembar		    = (ImageView)findViewById(R.id.imageView1);

        Intent i 		= getIntent();
        position 		= i.getExtras().getInt("position");
        HargaBurger		= i.getStringExtra("HargaBurger");
        NamaBurger		= i.getStringExtra("NamaBurger");
        Deskripsi	 	= i.getStringExtra("Deskripsi");
        Gambar			= i.getIntExtra("Gambar", Gambar);


        tvHargaBurger.setText(HargaBurger);
        tvNamaBurger.setText(NamaBurger);
        tvDeskripsi.setText(Deskripsi);
        ImgGembar.setImageResource(Gambar);


    }

}
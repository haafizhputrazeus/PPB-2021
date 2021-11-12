package com.example.listviewmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


class ListViewAdapterCall extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<Adaptormenu> viewadapterlist;
    private ArrayList<Adaptormenu> arraylist;

    public ListViewAdapterCall(Context context,	List<Adaptormenu> viewadapterlist) {
        mContext = context;
        this.viewadapterlist = viewadapterlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist  = new ArrayList<Adaptormenu>();
        this.arraylist.addAll(viewadapterlist);
    }

    public class ViewHolder {
        TextView NamaBurger;
        TextView HargaBurger;
        ImageView Gambar;
    }

    @Override
    public int getCount() {
        return viewadapterlist.size();
    }

    @Override
    public Adaptormenu getItem(int position) {
        return viewadapterlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_icon_makanan, null);
            holder.NamaBurger 	= (TextView) view.findViewById(R.id.textView1);
            holder.HargaBurger 	= (TextView) view.findViewById(R.id.textView2);
            holder.Gambar 		= (ImageView) view.findViewById(R.id.imageView1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.NamaBurger.setText(viewadapterlist.get(position).getNamaBurger());
        holder.HargaBurger.setText(viewadapterlist.get(position).getHargaBurger());
        holder.Gambar.setImageResource(viewadapterlist.get(position).getGambar());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, Detail_Makanan.class);
                intent.putExtra("HargaBurger",(viewadapterlist.get(position).getHargaBurger()));
                intent.putExtra("NamaBurger",	(viewadapterlist.get(position).getNamaBurger()));
                intent.putExtra("Deskripsi",(viewadapterlist.get(position).getDeskripsi()));
                intent.putExtra("Gambar",	(viewadapterlist.get(position).getGambar()));

                mContext.startActivity(intent);
            }
        });
        return view;
    }


    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        viewadapterlist.clear();
        if (charText.length() == 0) {
            viewadapterlist.addAll(arraylist);
        } else {
            for (Adaptormenu wp : arraylist) {
                if (wp.getNamaBurger().toLowerCase(Locale.getDefault()).contains(charText)) {
                    viewadapterlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}


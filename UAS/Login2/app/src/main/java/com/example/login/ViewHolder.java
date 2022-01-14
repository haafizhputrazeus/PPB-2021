package com.example.login;

import android.view.View;
import android.view.ViewGroup;

public interface ViewHolder {
    int getCount();

    Adaptormenu getItem(int position);

    long getItemId(int position);

    View getView(int position, View view, ViewGroup parent);
}

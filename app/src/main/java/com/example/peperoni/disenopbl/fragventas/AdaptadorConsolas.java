package com.example.peperoni.disenopbl.fragventas;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class AdaptadorConsolas extends BaseAdapter{
    private TabConsolas misConsolas;
    public AdaptadorConsolas() {
    }

    public AdaptadorConsolas(TabConsolas misConsolas) {
        this.misConsolas = misConsolas;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

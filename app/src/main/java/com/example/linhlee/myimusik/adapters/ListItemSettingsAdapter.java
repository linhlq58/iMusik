package com.example.linhlee.myimusik.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.linhlee.myimusik.activities.MainActivity;
import com.example.linhlee.myimusik.R;

import java.util.ArrayList;

/**
 * Created by Linh Lee on 4/4/2016.
 */
public class ListItemSettingsAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private ArrayList<String> listItem;

    public ListItemSettingsAdapter(MainActivity context, int layout, ArrayList<String> listItem) {
        this.context = context;
        this.layout = layout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(layout, parent, false);
        }

        TextView itemText = (TextView) convertView.findViewById(R.id.item_text);
        itemText.setText(listItem.get(position));

        return convertView;
    }
}

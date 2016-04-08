package com.example.linhlee.myimusik.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.linhlee.myimusik.adapters.ListItemSettingsAdapter;
import com.example.linhlee.myimusik.activities.MainActivity;
import com.example.linhlee.myimusik.R;

import java.util.ArrayList;

/**
 * Created by Linh Lee on 4/4/2016.
 */
public class SettingsFragment extends Fragment {

    private ListView listView;
    private ListItemSettingsAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("About");
        arrayList.add("Copyright");
        arrayList.add("More apps");

        listView = (ListView) rootView.findViewById(R.id.list_settings_item);

        listAdapter = new ListItemSettingsAdapter((MainActivity)getActivity(), R.layout.settings_item, arrayList);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showDialog();
                    case 1:
                    case 2:
                }
            }
        });

        return rootView;
    }

    private void showDialog() {
        final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setMessage("Created by Linh Lee");
        alertDialog.show();
    }
}

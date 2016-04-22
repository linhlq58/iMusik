package com.example.linhlee.myimusik.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.linhlee.myimusik.R;
import com.example.linhlee.myimusik.activities.AboutActivity;
import com.example.linhlee.myimusik.activities.CopyrightActivity;
import com.example.linhlee.myimusik.activities.MainActivity;
import com.example.linhlee.myimusik.adapters.ListItemSettingsAdapter;

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

        listAdapter = new ListItemSettingsAdapter((MainActivity) getActivity(), R.layout.settings_item, arrayList);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent((MainActivity) getActivity(), AboutActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent((MainActivity) getActivity(), CopyrightActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Uri uri = Uri.parse("https://play.google.com/store");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                }
            }
        });

        return rootView;
    }

}

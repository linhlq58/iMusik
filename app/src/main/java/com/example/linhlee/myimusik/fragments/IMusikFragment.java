package com.example.linhlee.myimusik.fragments;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;

import com.example.linhlee.myimusik.R;
import com.example.linhlee.myimusik.activities.MainActivity;
import com.example.linhlee.myimusik.adapters.GridItemMusicAdapter;
import com.example.linhlee.myimusik.objects.MusicItem;

import java.util.ArrayList;

/**
 * Created by Linh Lee on 4/4/2016.
 */
public class IMusikFragment extends Fragment {

    private GridView gridView;
    private GridItemMusicAdapter gridAdapter;
    private ArrayList<MusicItem> arrayList;

    private boolean playingAll = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_imusik, container, false);

        final Button btnPlayAll = (Button) rootView.findViewById(R.id.btn_playall);

        initArray();

        gridView = (GridView) rootView.findViewById(R.id.grid_item_music);

        gridAdapter = new GridItemMusicAdapter((MainActivity)getActivity(), R.layout.music_item, arrayList);

        gridView.setAdapter(gridAdapter);

        final MediaPlayer[] mp;
        mp = new MediaPlayer[arrayList.size()];

        btnPlayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playingAll) {
                    btnPlayAll.setText("Play All");
                    for (int i=0;i<arrayList.size();i++) {
                        mp[i].stop();
                        mp[i].release();
                        mp[i] = null;
                        arrayList.get(i).setIsPlaying(false);
                    }
                    playingAll = false;
                } else {
                    btnPlayAll.setText("Stop All");
                    for (int i=0;i<arrayList.size();i++) {
                        mp[i] = MediaPlayer.create((MainActivity)getActivity(), arrayList.get(i).getAudioRes());
                        mp[i].start();
                        arrayList.get(i).setIsPlaying(true);
                    }
                    playingAll = true;
                }
            }
        });

        return rootView;
    }

    private void initArray() {
        arrayList = new ArrayList<>();
        arrayList.add(new MusicItem(R.mipmap.rain, R.mipmap.rain_white, R.raw.rain, false));
        arrayList.add(new MusicItem(R.mipmap.thunderstorm, R.mipmap.thunderstorm_white, R.raw.thunderstorm, false));
        arrayList.add(new MusicItem(R.mipmap.wind, R.mipmap.wind_white, R.raw.wind, false));
        arrayList.add(new MusicItem(R.mipmap.forest, R.mipmap.forest_white, R.raw.forest, false));
        arrayList.add(new MusicItem(R.mipmap.leaves, R.mipmap.leaves_white, R.raw.leaves, false));
        arrayList.add(new MusicItem(R.mipmap.waterstream, R.mipmap.waterstream_white, R.raw.waterstream, false));
        arrayList.add(new MusicItem(R.mipmap.seaside, R.mipmap.seaside_white, R.raw.seaside, false));
        arrayList.add(new MusicItem(R.mipmap.water, R.mipmap.water_white, R.raw.water, false));
        arrayList.add(new MusicItem(R.mipmap.fireplace, R.mipmap.fireplace_white, R.raw.fireplace, false));
        arrayList.add(new MusicItem(R.mipmap.night, R.mipmap.night_white, R.raw.night, false));
        arrayList.add(new MusicItem(R.mipmap.coffee, R.mipmap.coffee_white, R.raw.coffee, false));
        arrayList.add(new MusicItem(R.mipmap.train, R.mipmap.train_white, R.raw.train, false));
        arrayList.add(new MusicItem(R.mipmap.fan, R.mipmap.fan_white, R.raw.fan, false));
        arrayList.add(new MusicItem(R.mipmap.noise, R.mipmap.noise, R.raw.thunderstorm, false));
    }

}

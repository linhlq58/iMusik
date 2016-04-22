package com.example.linhlee.myimusik.fragments;

import android.content.Context;
import android.content.Intent;
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

    private int[] listImg = {R.mipmap.rain, R.mipmap.thunderstorm, R.mipmap.wind,
            R.mipmap.forest, R.mipmap.leaves, R.mipmap.waterstream,
            R.mipmap.seaside, R.mipmap.water, R.mipmap.fireplace,
            R.mipmap.night, R.mipmap.coffee, R.mipmap.train,
            R.mipmap.fan, R.mipmap.noise};

    private int[] listWhiteImg = {R.mipmap.rain_white, R.mipmap.thunderstorm_white, R.mipmap.wind_white,
            R.mipmap.forest_white, R.mipmap.leaves_white, R.mipmap.waterstream_white,
            R.mipmap.seaside_white, R.mipmap.water_white, R.mipmap.fireplace_white,
            R.mipmap.night_white, R.mipmap.coffee_white, R.mipmap.train_white,
            R.mipmap.fan_white, R.mipmap.noise_white};

    private int[] listMusic = {R.raw.rain, R.raw.thunderstorm, R.raw.wind, R.raw.forest,
            R.raw.leaves, R.raw.waterstream, R.raw.seaside, R.raw.water,
            R.raw.fireplace, R.raw.night, R.raw.coffee,
            R.raw.train, R.raw.fan, R.raw.wind};

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

        btnPlayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playingAll) {
                    btnPlayAll.setText("Play All");
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getMp() != null && arrayList.get(i).isPlaying() == true) {
                            arrayList.get(i).getMp().stop();
                            arrayList.get(i).getMp().release();
                            arrayList.get(i).setMp(null);
                            arrayList.get(i).setIsPlaying(false);

                        }

                    }
                    playingAll = false;
                } else {
                    btnPlayAll.setText("Stop All");
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getMp() == null && arrayList.get(i).isPlaying() == false) {
                            arrayList.get(i).setMp(MediaPlayer.create((MainActivity) getActivity(), arrayList.get(i).getAudioRes()));
                            arrayList.get(i).getMp().start();
                            arrayList.get(i).setIsPlaying(true);

                        }
                    }
                    playingAll = true;
                }
                gridAdapter.notifyDataSetChanged();
            }
        });

        gridView.setAdapter(gridAdapter);

        return rootView;
    }

    private void initArray() {
        arrayList = new ArrayList<>();
        for (int i = 0;i < 14;i++) {
            arrayList.add(new MusicItem(listImg[i], listWhiteImg[i], listMusic[i], false));
        }
    }

}

package com.example.linhlee.myimusik.adapters;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linhlee.myimusik.R;
import com.example.linhlee.myimusik.activities.MainActivity;
import com.example.linhlee.myimusik.objects.MusicItem;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Linh Lee on 4/4/2016.
 */
public class GridItemMusicAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private ArrayList<MusicItem> listItem;

    private final static int MAX_VOLUME = 100;

    public GridItemMusicAdapter(MainActivity context, int layout, ArrayList<MusicItem> listItem) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(layout, parent, false);
        }

        String[] arrayColor = {"#3BB9FF", "#38ACEC", "#38ACEC", "#3BB9FF",
                "#3BB9FF", "#38ACEC", "#38ACEC", "#3BB9FF",
                "#3BB9FF", "#38ACEC", "#38ACEC", "#3BB9FF",
                "#3BB9FF", "#38ACEC"};

        LinearLayout gridItemLayout = (LinearLayout) convertView.findViewById(R.id.grid_item_layout);
        gridItemLayout.setBackgroundColor(Color.parseColor(arrayColor[position]));

        final ImageView img = (ImageView) convertView.findViewById(R.id.img);
        img.setImageResource(listItem.get(position).getImgRes());


        final SeekBar volumeSeekBar;
        final AudioManager audioManager;

        final MediaPlayer[] mp = {null};

        try {
            volumeSeekBar = (SeekBar) convertView.findViewById(R.id.seek_bar);
            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            volumeSeekBar.setMax(MAX_VOLUME);
            volumeSeekBar.setProgress(MAX_VOLUME * audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

            volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    float volume = (float) (1 - (Math.log(100 - progress) / Math.log(100)));
                    if (mp[0] != null) {
                        mp[0].setVolume(volume, volume);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp[0] != null && listItem.get(position).isPlaying() == true) {
                    mp[0].stop();
                    mp[0].release();
                    mp[0] = null;
                    img.setImageResource(listItem.get(position).getImgRes());
                    listItem.get(position).setIsPlaying(false);
                } else if (mp[0] == null && listItem.get(position).isPlaying() == false) {

                    mp[0] = MediaPlayer.create(context, listItem.get(position).getAudioRes());
                    mp[0].start();
                    img.setImageResource(listItem.get(position).getImgWhiteRes());
                    listItem.get(position).setIsPlaying(true);
                }

            }
        });

        return convertView;
    }

}

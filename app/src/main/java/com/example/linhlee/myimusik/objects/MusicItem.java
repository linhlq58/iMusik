package com.example.linhlee.myimusik.objects;

import android.media.MediaPlayer;

/**
 * Created by Linh Lee on 4/4/2016.
 */
public class MusicItem {
    private int imgRes;
    private int imgWhiteRes;
    private int audioRes;
    private boolean isPlaying;

    public MusicItem(int imgRes,int imgWhiteRes, int audioRes, boolean isPlaying) {
        this.imgRes = imgRes;
        this.imgWhiteRes = imgWhiteRes;
        this.audioRes = audioRes;
        this.isPlaying = isPlaying;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getImgWhiteRes() {
        return imgWhiteRes;
    }

    public void setImgWhiteRes(int imgWhiteRes) {
        this.imgWhiteRes = imgWhiteRes;
    }

    public int getAudioRes() {
        return audioRes;
    }

    public void setAudioRes(int audioRes) {
        this.audioRes = audioRes;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
}

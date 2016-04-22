package com.example.linhlee.myimusik.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.astuetz.PagerSlidingTabStrip;
import com.example.linhlee.myimusik.R;
import com.example.linhlee.myimusik.adapters.MyPagerAdapter;
import com.example.linhlee.myimusik.fragments.IMusikFragment;
import com.example.linhlee.myimusik.fragments.SettingsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        IMusikFragment iMusikFragment = new IMusikFragment();
        SettingsFragment settingsFragment = new SettingsFragment();

        fragments = new ArrayList<>();
        fragments.add(iMusikFragment);
        fragments.add(settingsFragment);

        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        pager.setAdapter(adapter);

        tabs.setViewPager(pager);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }

}

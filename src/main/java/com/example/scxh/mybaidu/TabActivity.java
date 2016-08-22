package com.example.scxh.mybaidu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class TabActivity extends android.app.TabActivity {
    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabHost=getTabHost();
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View v1=layoutInflater.inflate(R.layout.tab1_layout,null);
        View v2=layoutInflater.inflate(R.layout.geid2_layout,null);
        View v3=layoutInflater.inflate(R.layout.grid3_layout,null);
        View v4=layoutInflater.inflate(R.layout.grid4_layout,null);

        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("tab1");
        tabSpec1.setIndicator(v1);
        tabSpec1.setContent(new Intent(this,MainActivity.class));

        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("tab2");
        tabSpec2.setIndicator(v2);
        tabSpec2.setContent(new Intent(this,ListActivity.class));

        TabHost.TabSpec tabSpec3=tabHost.newTabSpec("tab3");
        tabSpec3.setIndicator(v3);
        tabSpec3.setContent(new Intent(this,personActivity.class));

        TabHost.TabSpec tabSpec4=tabHost.newTabSpec("tab4");
        tabSpec4.setIndicator(v4);
        tabSpec4.setContent(new Intent(this,MeActivity.class));

        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
        tabHost.addTab(tabSpec4);
    }
}

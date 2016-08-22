package com.example.scxh.mybaidu;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private ImageView imageView1,imageView2,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        imageView1= (ImageView) findViewById(R.id.view_pager_img1);
        imageView2= (ImageView) findViewById(R.id.view_pager_img2);
        imageView3= (ImageView) findViewById(R.id.view_pager_img3);


        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View v1=layoutInflater.inflate(R.layout.viewpager1_layout,null);
        View v2=layoutInflater.inflate(R.layout.viewpager2_layout,null);
        View v3=layoutInflater.inflate(R.layout.viewpager3_layout,null);

        List<View> list=new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);

        viewpagerAdapter viewpagerAdapter=new viewpagerAdapter(list,this);
        viewPager.setAdapter(viewpagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            switch (position){
                case 2:
                   Intent intent=new Intent(ViewPagerActivity.this,TabActivity.class);
                    startActivity(intent);
                    finish();
              }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_pager_img3:
                Intent intent=new Intent(this,QishiActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    public class viewpagerAdapter extends PagerAdapter{
        private List<View> list=new ArrayList<>();
        private LayoutInflater layoutInflater;
        public viewpagerAdapter(List<View> list, Context context){
            layoutInflater=LayoutInflater.from(context);
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        public Object instantiateItem(ViewGroup container, int position) {
            View v = list.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = list.get(position);
            container.removeView(v);
        }
    }
}

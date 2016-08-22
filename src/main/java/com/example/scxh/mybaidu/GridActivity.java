package com.example.scxh.mybaidu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView= (GridView) findViewById(R.id.grid);

        int[] array={R.drawable.baidu01,R.drawable.baidu2,R.drawable.baidu3,R.drawable.baidu2,R.drawable.baidu2,R.drawable.baidu2,R.drawable.baidu2,R.drawable.baidu2,R.drawable.baidu2,R.drawable.baidu2};
        myAdapter adapter=new myAdapter(this);
        adapter.setImageResIds(array);
        gridView.setAdapter(adapter);

    }
    public class myAdapter extends BaseAdapter{
        private int[] arrays=new int[]{};
        private LayoutInflater layoutInflater;
        public myAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);
        }
        public void setImageResIds(int[] array) {
            this.arrays = array;
        }
        @Override
        public int getCount() {
            return arrays.length;
        }

        @Override
        public Object getItem(int position) {
            return arrays[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.txt_layout,null);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.item_grid_txt);
                convertView.setTag(imageView);
            }
            ImageView imageView = (ImageView) convertView.getTag();
            imageView.setImageResource((Integer) getItem(position));
            return convertView;
        }
    }
}

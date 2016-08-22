package com.example.scxh.mybaidu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mtoolbar;
    private ViewPager mviewPager;
    private Spinner mspinner1,mspinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar1);
        mviewPager = (ViewPager) findViewById(R.id.pager_view);
        ArrayList arrays = getListData();


        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View v1 = layoutInflater.inflate(R.layout.grid1_layout, null);
        View v2 = layoutInflater.inflate(R.layout.grid2_layout, null);


        GridView gridView1 = (GridView) v1.findViewById(R.id.gridview1);
        GridView gridView2 = (GridView) v2.findViewById(R.id.gridview2);

        ArrayList<View> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        String[] form = {"icon", "title"};
        int[] to = {R.id.scroll_img, R.id.scrll_txt};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrays, R.layout.item_scroll_ayout, form, to);
        gridView1.setAdapter(simpleAdapter);
        simpleAdapter = new SimpleAdapter(this, arrays, R.layout.item_scroll_ayout, form, to);
        gridView2.setAdapter(simpleAdapter);
        myAdapter adapter = new myAdapter(this, list);
        mviewPager.setAdapter(adapter);
        // TODO: 2016/6/23 Spinner控件的使用
        mspinner1= (Spinner) findViewById(R.id.spinner1);
        mspinner2= (Spinner) findViewById(R.id.spinner2);
        String[] spinnerArray1={"商家分类","全部","新店特惠","连锁餐厅","家常快餐","地方菜","特色小吃"};
        String[] spinnerArray2={"智能排序","销量最高","距离最近","评分最高","起送价最低","送餐最快"};
        ArrayAdapter<String> arrayAdapterOne=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinnerArray1);
        ArrayAdapter<String> arrayAdapterTwo=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinnerArray2);
        mspinner1.setAdapter(arrayAdapterOne);
        mspinner2.setAdapter(arrayAdapterTwo);



    }
    public class ListViewAdapter extends BaseAdapter{
        private ArrayList<MessageBean> list=new ArrayList<>();
        LayoutInflater layoutinflater;
        public ListViewAdapter(Context context,ArrayList<MessageBean> list){
            layoutinflater=LayoutInflater.from(context);
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //TODO一级优化  优化View不被重复解析
            ViewHolder viewHolder;
            if(convertView==null) {
                convertView = layoutinflater.inflate(R.layout.item_listview_layout, null);
                ImageView iconImg = (ImageView) convertView.findViewById(R.id.list_img);
                TextView titleTxt = (TextView) convertView.findViewById(R.id.list_title);
                ImageView iconImgxin = (ImageView) convertView.findViewById(R.id.list_img2);
                TextView contentTxt = (TextView) convertView.findViewById(R.id.list_text1);
                ImageView bottomImag1 = (ImageView) convertView.findViewById(R.id.bottom_img1);
                TextView bottomTxt1 = (TextView) convertView.findViewById(R.id.bottom_txt1);
                ImageView bottomImag2 = (ImageView) convertView.findViewById(R.id.bottom_img2);
                TextView bottomTxt2 = (TextView) convertView.findViewById(R.id.bottom_txt2);

                viewHolder=new ViewHolder();
                viewHolder.iconImg=iconImg;
                viewHolder.titleTxt=titleTxt;
                viewHolder.iconImgxin=iconImgxin;
                viewHolder.contentTxt=contentTxt;
                viewHolder.bottomImag1=bottomImag1;
                viewHolder.bottomOne=bottomTxt1;
                viewHolder.getBottomImag2=bottomImag2;
                viewHolder.getBottomTwo=bottomTxt2;

                convertView.setTag(viewHolder);
            }

            viewHolder = (ViewHolder) convertView.getTag();
            //从View对象中获取控件实例
           MessageBean messageBean = (MessageBean) getItem(position);
            viewHolder.iconImg.setImageResource(messageBean.getIconImg());
            viewHolder.titleTxt.setText(messageBean.getTitleTxt());
            viewHolder.iconImgxin.setImageResource(messageBean.getIconImgxin());
            viewHolder.contentTxt.setText(messageBean.getContentTxt());
            viewHolder.bottomImag1.setImageResource(messageBean.getBottomImag1());
            viewHolder.bottomOne.setText(messageBean.getBottomOne());
            viewHolder.getBottomImag2.setImageResource(messageBean.getBottomImag2);
            viewHolder.getBottomTwo.setText(messageBean.getBottomTwo);

            return convertView;

        }
        public class ViewHolder{
            ImageView iconImg;
            TextView titleTxt;
            ImageView iconImgxin;
            TextView contentTxt;
            ImageView bottomImag1;
            TextView bottomOne;
            ImageView getBottomImag2;
            TextView getBottomTwo;
        }
    }
    public class myAdapter extends PagerAdapter {
        private List<View> list = new ArrayList<>();
        private LayoutInflater layoutInflater;

        public myAdapter(Context context, List<View> list) {
            layoutInflater = LayoutInflater.from(context);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
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


    public class AcceptData {
        int icom;
        String title;

        public AcceptData(int icom, String title) {
            this.icom = icom;
            this.title = title;
        }
    }

    public ArrayList getListData() {
        ArrayList listData = new ArrayList();

        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_0);
        item.put("title", "美食");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_1);
        item.put("title", "电影");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_2);
        item.put("title", "酒店");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_10);
        item.put("title", "休闲娱乐");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_34);
        item.put("title", "外卖");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_36);
        item.put("title", "自助餐");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_30);
        item.put("title", "美容");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_31);
        item.put("title", "出租");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_28);
        item.put("title", "珠宝");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_25);
        item.put("title", "地铁");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_22);
        item.put("title", "书店");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_37);
        item.put("title", "游乐园");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_32);
        item.put("title", "糕点");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_33);
        item.put("title", "甜食");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_24);
        item.put("title", "茶饮");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_35);
        item.put("title", "健身");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_11);
        item.put("title", "美发");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_12);
        item.put("title", "海滩");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_13);
        item.put("title", "沙滩");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.ic_category_14);
        item.put("title", "礼物");
        listData.add(item);

        item = new HashMap<String, Object>();
        item.put("icon", R.mipmap.waimai);
        item.put("title", "外卖");
        listData.add(item);
        return listData;
    }

}

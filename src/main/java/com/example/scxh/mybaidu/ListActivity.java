package com.example.scxh.mybaidu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView= (ListView) findViewById(R.id.listview);
        ArrayList<MessageBean> list=data();
        ListViewAdapter listViewAdapter=new ListViewAdapter(this,list);
        listView.setAdapter(listViewAdapter);
    }

    public class ListViewAdapter extends BaseAdapter {
        private ArrayList<MessageBean> list = new ArrayList<>();
        LayoutInflater layoutinflater;

        public ListViewAdapter(Context context, ArrayList<MessageBean> list) {
            layoutinflater = LayoutInflater.from(context);
            this.list = list;
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
            //todo一级优化  优化View不被重复解析
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = layoutinflater.inflate(R.layout.item_listview_layout, null);
                ImageView iconImg = (ImageView) convertView.findViewById(R.id.list_item_img);
                TextView titleTxt = (TextView) convertView.findViewById(R.id.list_item_title);
                ImageView iconImgxin = (ImageView) convertView.findViewById(R.id.list_item_img2);
                TextView contentTxt = (TextView) convertView.findViewById(R.id.list_item_text1);
                ImageView bottomImag1 = (ImageView) convertView.findViewById(R.id.bottom_item_img1);
                TextView bottomTxt1 = (TextView) convertView.findViewById(R.id.bottom_item_txt1);
                ImageView bottomImag2 = (ImageView) convertView.findViewById(R.id.bottom_item_img2);
                TextView bottomTxt2 = (TextView) convertView.findViewById(R.id.bottom_item_txt2);

                viewHolder = new ViewHolder();
                viewHolder.iconImg = iconImg;
                viewHolder.titleTxt = titleTxt;
                viewHolder.iconImgxin = iconImgxin;
                viewHolder.contentTxt = contentTxt;
                viewHolder.bottomImag1 = bottomImag1;
                viewHolder.bottomOne = bottomTxt1;
                viewHolder.getBottomImag2 = bottomImag2;
                viewHolder.getBottomTwo = bottomTxt2;

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

        public class ViewHolder {
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
    public ArrayList data(){
        ArrayList<MessageBean> data = new ArrayList<>();

        MessageBean item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.mipmap.m20160624112742);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.m20160624113008);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.m20160624113201);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.m20160624113317);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        item = new MessageBean();
        item.setIconImg(R.drawable.meituan_image2);
        item.setTitleTxt("味之源黄焖鸡米饭");
        item.setIconImgxin(R.mipmap.l20160623094314);
        item.setContentTxt("起送 ¥0|配送 ¥0  月送 686份");
        item.setBottomImag1(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setBottomOne("新用户在线支付立减12元，使用百度钱包立减22元");
        item.setGetBottomImag2(R.mipmap.waimai_shoplist_item_icon_jian);
        item.setGetBottomTwo("在线支付满15元减2.5元，满25元减11元，满45元减15元");
        data.add(item);

        return data;
    }
}

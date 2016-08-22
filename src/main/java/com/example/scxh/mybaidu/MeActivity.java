package com.example.scxh.mybaidu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeActivity extends AppCompatActivity implements View.OnClickListener{
    private GridView gridView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        gridView= (GridView) findViewById(R.id.grid_me);
        List list=getData();
        myGridAdapter adapter=new myGridAdapter(this,list);
        gridView.setAdapter(adapter);

        button= (Button) findViewById(R.id.meBtn);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MeActivity.this,QishiActivity.class);
        startActivity(intent);
        finish();
    }

    public class myGridAdapter extends BaseAdapter{
        List<Bean> list=new ArrayList<>();
        LayoutInflater layoutInflater;
        public myGridAdapter(Context context,List<Bean> list){
            layoutInflater=LayoutInflater.from(context);
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
            ViewHolder viewHolder;
            if (convertView==null){
               convertView=layoutInflater.inflate(R.layout.grid_me_layout,null);
                ImageView iconImg = (ImageView)convertView.findViewById(R.id.item_grid_me_img);
                TextView title= (TextView) convertView.findViewById(R.id.item_grid_me_txt);

                viewHolder=new ViewHolder();
                viewHolder.iconImg=iconImg;
                viewHolder.titleTxt=title;
               convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();
            Bean bean= (Bean) getItem(position);
            viewHolder.iconImg.setImageResource(bean.getIcon());
            viewHolder.titleTxt.setText(bean.getTitle());

            return convertView;
        }
        class ViewHolder{
            ImageView iconImg;
            TextView titleTxt;
        }
    }
    public class Bean{
        int icon;
        String title;

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
    public List<Bean> getData(){
        List<Bean> list=new ArrayList<>();

        Bean bean=new Bean();
        bean.setIcon(R.mipmap.order_status_rider_icon);
        bean.setTitle("分享有礼");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.drawable.adress);
        bean.setTitle("我的地址");
        list.add(bean);


        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_money_icon);
        bean.setTitle("我的评价");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_service_icon);
        bean.setTitle("我的退款");
        list.add(bean);


        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_shop_icon);
        bean.setTitle("在线客服");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_user_icon);
        bean.setTitle("我的消息");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.waimai_switchaddress_icon_location);
        bean.setTitle("常见问题");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.drawable.shop);
        bean.setTitle("商家入驻");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_shop_icon);
        bean.setTitle("成长轨迹");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.wallet_base_trans_default_icon);
        bean.setTitle("分享有礼");
        list.add(bean);

        bean=new Bean();
        bean.setIcon(R.mipmap.order_status_shop_icon);
        bean.setTitle("分享有礼");
        list.add(bean);

        return list;
    }
}

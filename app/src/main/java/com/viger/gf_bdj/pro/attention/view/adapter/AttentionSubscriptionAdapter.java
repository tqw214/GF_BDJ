package com.viger.gf_bdj.pro.attention.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.viger.gf_bdj.R;
import com.viger.gf_bdj.bean.AttentionSubscriptionBean;
import com.viger.gf_bdj.pro.essence.view.views.CircleNetworkImageImage;
import com.viger.gf_bdj.utils.VolleyUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AttentionSubscriptionAdapter extends BaseAdapter{

    private Context context;
    private List<AttentionSubscriptionBean> subscriptionList;

    public AttentionSubscriptionAdapter(Context context,List<AttentionSubscriptionBean> subscriptionList){
        this.context = context;
        this.subscriptionList = subscriptionList;
    }

    @Override
    public int getCount() {
        return subscriptionList.size();
    }

    @Override
    public Object getItem(int position) {
        return subscriptionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_attention_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.iv_header = (CircleNetworkImageImage)convertView.findViewById(R.id.iv_header);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_attention_count = (TextView) convertView.findViewById(R.id.tv_attention_count);
            viewHolder.bt_attention = (Button) convertView.findViewById(R.id.bt_attention);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AttentionSubscriptionBean bean = subscriptionList.get(position);
        VolleyUtils.loadImage(context,viewHolder.iv_header,bean.getImage_list());

        viewHolder.tv_name.setText(bean.getTheme_name());
        viewHolder.tv_attention_count.setText(bean.getSub_number());
        return convertView;
    }

    class ViewHolder{
        public CircleNetworkImageImage iv_header;
        public TextView tv_name;
        public TextView tv_attention_count;
        public Button bt_attention;
    }

}

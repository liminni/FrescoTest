package com.lixiaoming.frescotest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lixiaoming.frescotest.R;

import java.util.List;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class CustomListViewAdapter extends BaseAdapter {

    public Context mContext;

    public List<String> data;

    private View.OnClickListener listener;

    public CustomListViewAdapter(Context context,List<String> list){
        this.mContext = context;
        this.data = list;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder  holder = null;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            holder.tv_item_content = ((TextView) view.findViewById(R.id.tv_item_content));

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_content.setText(data.get(position));
        holder.tv_item_content.setTag(position);
        holder.tv_item_content.setOnClickListener(listener);
        return view;
    }

    class ViewHolder{
      TextView tv_item_content;
    }
}

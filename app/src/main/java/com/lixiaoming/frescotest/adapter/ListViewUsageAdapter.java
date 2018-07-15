package com.lixiaoming.frescotest.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lixiaoming.frescotest.R;

import java.util.List;

/**
 * Created by lixiaoming on 17/3/15.
 */

public class ListViewUsageAdapter extends BaseAdapter {

    private List<String> data;

    private Context context;

    public ListViewUsageAdapter (List<String> data,Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
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
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.listview_usage_item,null);
            holder.drawee_Simple = ((SimpleDraweeView) view.findViewById(R.id.drawee_SimpleDrawee));
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.drawee_Simple.setImageURI(Uri.parse(data.get(position)));
        return view;
    }

    class ViewHolder{
        SimpleDraweeView drawee_Simple;
    }
}

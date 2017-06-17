package com.zx.dialoglib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zx on 2017/6/12 10:40
 * 项目名称：BottomDialog
 * 类描述：
 * 备注
 */
public class BottomAdapter<T extends Entity> extends BaseAdapter {
    Context context;
    List<T> datas;

    public BottomAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.mTv= (TextView) convertView.findViewById(R.id.tv);
            holder.tvLine= (TextView) convertView.findViewById(R.id.tv_line);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Entity t = datas.get(position);
        if (position == datas.size() - 1) {
            holder.tvLine.setVisibility(View.GONE);
        } else {
            holder.tvLine.setVisibility(View.VISIBLE);
        }
        //修改下泛型来适应实体类
        holder.mTv.setText(t.name);
        return convertView;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView mTv;
        TextView tvLine;
    }

}

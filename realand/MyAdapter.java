package com.example.it.database;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by it on 2018-03-27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    List<ProductVO> items;
    int itemLayout;

    public MyAdapter(List<ProductVO> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    //row.xml 객체 생성
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent , false);
        //parent -> mainActivity.

        Log.i("aa",parent.toString());
        Log.i("aa",parent.getContext().toString());

        return new ViewHolder(view);

    }

    //view 에 data 를 set 하는 역할.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductVO item = items.get(position);
        holder.tv_title.setText(item.getPname());
        holder.tv_janre.setText(item.getPjanre());
        //holder.img.setImageResource();
        //holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tv_title, tv_janre;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.iv);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_janre = itemView.findViewById(R.id.tv_janre);


        }
    }
}



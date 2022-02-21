package com.example.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Fruit> fruitList;

    public MyAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int i) {
        return fruitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view= LayoutInflater.from(context).inflate(R.layout.custom_row,viewGroup,false);
        ImageView myImageView=view.findViewById(R.id.myImage);
        TextView myTv=view.findViewById(R.id.myTv);
        Fruit fruit=fruitList.get(i);

        myTv.setText(fruit.getFruitName());
        myImageView.setImageResource(fruit.getFruitImage());

        return view;
    }
}

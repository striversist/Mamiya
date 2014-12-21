package com.ec.mamiya.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ec.mamiya.data.CategoryBrand;

public class CategoryGridAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<CategoryBrand> mBrands = new ArrayList<CategoryBrand>();
    
    public CategoryGridAdapter(Context context, ArrayList<CategoryBrand> brands) {
        assert (context != null);
        assert (brands != null);
        mContext = context;
        mBrands.addAll(brands);
    }
    
    @Override
    public int getCount() {
        return mBrands.size();
    }

    @Override
    public Object getItem(int position) {
        return mBrands.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = new ImageView(mContext);
        if (mBrands.get(position).drawableId > 0) {
            view.setImageResource(mBrands.get(position).drawableId);
        }
        
        convertView = view;
        return convertView;
    }

}

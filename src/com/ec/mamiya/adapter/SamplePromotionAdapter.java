package com.ec.mamiya.adapter;

import java.util.ArrayList;

import com.ec.mamiya.R;
import com.ec.mamiya.data.SpecialEntry;
import com.ec.mamiya.data.SeckillObj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SamplePromotionAdapter extends BaseAdapter {
    
    private Context mContext;
    private LayoutInflater mInflater;
    private enum ViewType {
        Banner, Seckill_CountingDown, Seckill_Item, SpecialEntry_Header, SpecialEntry_Item
    }
    private ArrayList<SeckillObj> mSeckillList = new ArrayList<SeckillObj>();
    private ArrayList<SpecialEntry> mSpecialEntryList = new ArrayList<SpecialEntry>();
    
    public SamplePromotionAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        
        /**
         *  Sample Data
         */
        String title, discount, price;
        // Seckill item 1
        title = context.getString(R.string.sample_seckill_item_title_1);
        discount = context.getString(R.string.sample_seckill_item_price_1);
        price = context.getString(R.string.sample_seckill_item_price_1);
        mSeckillList.add(new SeckillObj("1", title, discount, price, "1"));
        
        // Seckill item 2
        title = context.getString(R.string.sample_seckill_item_title_2);
        discount = context.getString(R.string.sample_seckill_item_price_2);
        price = context.getString(R.string.sample_seckill_item_price_2);
        mSeckillList.add(new SeckillObj("2", title, discount, price, "2"));
        
        String sTitle, sLeftDay, sDiscount;
        // Special item 1
        sTitle = context.getString(R.string.sample_special_entry_item_title_1);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_1);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_1);
        mSpecialEntryList.add(new SpecialEntry("1", sTitle, sLeftDay, sDiscount, "1"));
        
        // Special item 2
        sTitle = context.getString(R.string.sample_special_entry_item_title_2);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_2);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_2);
        mSpecialEntryList.add(new SpecialEntry("2", sTitle, sLeftDay, sDiscount, "2"));
        
        // Special item 3
        sTitle = context.getString(R.string.sample_special_entry_item_title_3);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_3);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_3);
        mSpecialEntryList.add(new SpecialEntry("3", sTitle, sLeftDay, sDiscount, "3"));
        
        // Special item 4
        sTitle = context.getString(R.string.sample_special_entry_item_title_4);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_4);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_4);
        mSpecialEntryList.add(new SpecialEntry("4", sTitle, sLeftDay, sDiscount, "4"));
    }
    
    @Override
    public int getViewTypeCount() {
        return ViewType.values().length;
    }
    
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ViewType.Banner.ordinal();
        } else if (position == 1) {
            return ViewType.Seckill_CountingDown.ordinal();
        } else if (position < mSeckillList.size() + 2) {
            return ViewType.Seckill_Item.ordinal();
        } else if (position == mSeckillList.size() + 2) {
            return ViewType.SpecialEntry_Header.ordinal();
        } else {
            return ViewType.SpecialEntry_Item.ordinal();
        }
    }
    
    @Override
    public int getCount() {
        return 3 + mSeckillList.size() + mSpecialEntryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // XXX: view不用每次inflate，有优化的空间
        switch (ViewType.values()[getItemViewType(position)]) {
            case Banner:
                view = mInflater.inflate(R.layout.promotion_banner, parent, false);
                break;
            case Seckill_CountingDown:
                view = mInflater.inflate(R.layout.seckill_header, parent, false);
                break;
            case Seckill_Item:
                view = mInflater.inflate(R.layout.seckill_list_item, parent, false);
                break;
            case SpecialEntry_Header:
                view = mInflater.inflate(R.layout.special_entry_header, parent, false);
                break;
            case SpecialEntry_Item:
                view = mInflater.inflate(R.layout.special_entry_list_item, parent, false);
                break;
        }
        return view;
    }

}

package com.ec.mamiya.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ec.mamiya.R;
import com.ec.mamiya.data.SeckillObj;
import com.ec.mamiya.data.SpecialEntry;
import com.ec.mamiya.view.SecKillHeader;
import com.ec.mamiya.view.SeckillListItem;
import com.ec.mamiya.view.SpecialEntryListItem;

public class SamplePromotionAdapter extends BaseAdapter {
    
    private Context mContext;
    private LayoutInflater mInflater;
    private enum ViewType {
        Banner, Seckill_Header, Seckill_Item, SpecialEntry_Header, SpecialEntry_Item
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
        SeckillObj seckillObj;
        // Seckill item 1
        title = context.getString(R.string.sample_seckill_item_title_1);
        discount = context.getString(R.string.sample_seckill_item_discount_1);
        price = context.getString(R.string.sample_seckill_item_price_1);
        seckillObj = new SeckillObj("1", title, discount, price, "1");
        seckillObj.setDrawableId(R.drawable.sample_seckill_pic_01);
        mSeckillList.add(seckillObj);
        
        // Seckill item 2
        title = context.getString(R.string.sample_seckill_item_title_2);
        discount = context.getString(R.string.sample_seckill_item_discount_2);
        price = context.getString(R.string.sample_seckill_item_price_2);
        seckillObj = new SeckillObj("2", title, discount, price, "2");
        seckillObj.setDrawableId(R.drawable.sample_seckill_pic_02);
        mSeckillList.add(seckillObj);
        
        String sTitle, sLeftDay, sDiscount;
        SpecialEntry entry;
        // Special item 1
        sTitle = context.getString(R.string.sample_special_entry_item_title_1);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_1);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_1);
        entry = new SpecialEntry("1", sTitle, sLeftDay, sDiscount, "1");
        entry.setDrawableId(R.drawable.sample_special_entry_item_01);
        mSpecialEntryList.add(entry);
        
        // Special item 2
        sTitle = context.getString(R.string.sample_special_entry_item_title_2);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_2);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_2);
        entry = new SpecialEntry("2", sTitle, sLeftDay, sDiscount, "2");
        entry.setDrawableId(R.drawable.sample_special_entry_item_02);
        mSpecialEntryList.add(entry);
        
        // Special item 3
        sTitle = context.getString(R.string.sample_special_entry_item_title_3);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_3);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_3);
        entry = new SpecialEntry("3", sTitle, sLeftDay, sDiscount, "3");
        entry.setDrawableId(R.drawable.sample_special_entry_item_03);
        mSpecialEntryList.add(entry);
        
        // Special item 4
        sTitle = context.getString(R.string.sample_special_entry_item_title_4);
        sLeftDay = context.getString(R.string.sample_special_entry_item_countdown_lefttime_4);
        sDiscount = context.getString(R.string.sample_special_entry_item_discount_4);
        entry = new SpecialEntry("4", sTitle, sLeftDay, sDiscount, "4");
        entry.setDrawableId(R.drawable.sample_special_entry_item_04);
        mSpecialEntryList.add(entry);
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
            return ViewType.Seckill_Header.ordinal();
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
            case Seckill_Header:
                view = new SecKillHeader(mContext);
                break;
            case Seckill_Item:
                SeckillListItem item = new SeckillListItem(mContext);
                item.setSeckillObj(mSeckillList.get(position - 2));
                view = item;
                break;
            case SpecialEntry_Header:
                view = mInflater.inflate(R.layout.special_entry_header, parent, false);
                break;
            case SpecialEntry_Item:
                SpecialEntryListItem entryItem = new SpecialEntryListItem(mContext);
                entryItem.setSpecialEntry(mSpecialEntryList.get(position - 3 - mSeckillList.size()));
                view = entryItem;
                break;
        }
        return view;
    }

}

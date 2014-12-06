package com.ec.mamiya.view;

import com.ec.mamiya.R;
import com.ec.mamiya.data.SpecialEntry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SpecialEntryListItem extends RelativeLayout {

    private Context mContext;
    private ImageView mPicture;
    private TextView mLeftTime;
    private TextView mTitle;
    private TextView mDiscount;
    private SpecialEntry mEntry;
    
    public SpecialEntryListItem(Context context) {
        this(context, null, 0);
    }
    
    public SpecialEntryListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SpecialEntryListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.special_entry_list_item, this);
        mPicture = (ImageView) findViewById(R.id.picture);
        mLeftTime = (TextView) findViewById(R.id.left_time);
        mTitle = (TextView) findViewById(R.id.title);
        mDiscount = (TextView) findViewById(R.id.discount);
    }

    public void setSpecialEntry(SpecialEntry entry) {
        assert (entry != null);
        mEntry = entry;
        update();
    }
    
    private void update() {
        if (mEntry == null)
            return;
        
        // For test
        if (mEntry.getDrawableId() != 0) {
            mPicture.setImageResource(mEntry.getDrawableId());
        } else {
            // TODO: Get from picture link            
        }
        mLeftTime.setText(mEntry.getLeftDay());
        mTitle.setText(mEntry.getTitle());
        mDiscount.setText(mEntry.getDiscount());
    }
}

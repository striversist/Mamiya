package com.ec.mamiya.view;

import com.ec.mamiya.R;
import com.ec.mamiya.data.SeckillObj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SeckillListItem extends LinearLayout {

    private Context mContext;
    private ImageView mPicture;
    private TextView mTitle;
    private TextView mDiscount;
    private TextView mPrice;
    private SeckillObj mSeckillObj;
    
    public SeckillListItem(Context context) {
        this(context, null, 0);
    }
    
    public SeckillListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SeckillListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.seckill_list_item, this);
        mPicture = (ImageView) findViewById(R.id.picture);
        mTitle = (TextView) findViewById(R.id.title);
        mDiscount = (TextView) findViewById(R.id.discount);
        mPrice = (TextView) findViewById(R.id.price);
    }

    public void setSeckillObj(SeckillObj seckillObj) {
        assert (seckillObj != null);
        mSeckillObj = seckillObj;
        update();
    }
    
    private void update() {
        if (mSeckillObj == null)
            return;
        
        // For test
        if (mSeckillObj.getDrawableId() != 0) {
            mPicture.setImageResource(mSeckillObj.getDrawableId());
        } else {
            // TODO: Get picture from picture link
        }
        mTitle.setText(mSeckillObj.getTitle());
        mDiscount.setText(mSeckillObj.getDiscount());
        mPrice.setText(mSeckillObj.getPrice());
    }
}

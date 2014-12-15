package com.ec.mamiya.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.ec.mamiya.R;

public class ProductBasicView extends RelativeLayout {

    private Context mContext;
    
    public ProductBasicView(Context context) {
        this(context, null, 0);
    }
    
    public ProductBasicView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public ProductBasicView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.product_basic_view, this);
    }
}

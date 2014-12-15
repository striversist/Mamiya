package com.ec.mamiya.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ec.mamiya.R;

public class SmallStarScroreView extends LinearLayout {
    
    private Context mContext;
    
    public SmallStarScroreView(Context context) {
        this(context, null, 0);
    }
    
    public SmallStarScroreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SmallStarScroreView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.small_star_score, this);
    }
}

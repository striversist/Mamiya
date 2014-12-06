package com.ec.mamiya.view;

import com.ec.mamiya.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecKillView extends RelativeLayout {

    private Context mContext;
    private TextView mTimeTextView;
    private CountingTimerView mCountingTimerView;
    
    public SecKillView(Context context) {
        this(context, null, 0);
    }
    
    public SecKillView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SecKillView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.seckill_header, this);
        mTimeTextView = (TextView) findViewById(R.id.time_tv);
        mCountingTimerView = (CountingTimerView) findViewById(R.id.counting_timer);
    }

    public void setTime(int hours, int minutes) {
        mTimeTextView.setText(hours + ":" + minutes);
    }
    
    public void setCountingDownTime(long leftTimeInMillis) {
        mCountingTimerView.startCountDown(leftTimeInMillis, 1000);
    }
}

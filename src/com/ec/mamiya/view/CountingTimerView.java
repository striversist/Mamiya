package com.ec.mamiya.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ec.mamiya.R;

public class CountingTimerView extends LinearLayout {
    
    private CountDownTimer mCountDownTimer;
    private OnCountDownListener mListener;
    public static abstract interface OnCountDownListener {
        public abstract boolean onCountDownFinishState();
    }
    
    private Context mContext;
    private TextView mTensHour;
    private TextView mHour;
    private TextView mTensMinute;
    private TextView mMinute;
    private TextView mTensSecond;
    private TextView mSecond;
    
    public CountingTimerView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.counting_timer_view, this);
        
        mContext = context;
        mTensHour = (TextView) findViewById(R.id.tens_hour);
        mHour = (TextView) findViewById(R.id.hour);
        mTensMinute = (TextView) findViewById(R.id.tens_minute);
        mMinute = (TextView) findViewById(R.id.minute);
        mTensSecond = (TextView) findViewById(R.id.tens_second);
        mSecond = (TextView) findViewById(R.id.second);
    }

    public void startCountDown(long millisInFuture, long countDownInterval) {
        setEnabled(false);
        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(millisInFuture, countDownInterval) {
                @Override
                public void onFinish() {
                    if (mListener != null) {
                        setEnabled(mListener.onCountDownFinishState());
                    } else {
                        setEnabled(true);
                    }
                }

                @Override
                public void onTick(long millisUntilFinished) {
                    long hundreds, seconds, minutes, hours;
                    seconds = millisUntilFinished / 1000;
                    hundreds = (millisUntilFinished - seconds * 1000) / 10;
                    minutes = seconds / 60;
                    seconds = seconds - minutes * 60;
                    hours = minutes / 60;
                    minutes = minutes - hours * 60;
                    setTime(hours, minutes, seconds);
                }
            };
        }
        mCountDownTimer.start();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    public void setOnCountDownListener(OnCountDownListener onCountDownListener) {
        mListener = onCountDownListener;
    }
    
    private void setTime(long hours, long minutes, long seconds) {
        mTensHour.setText(String.valueOf(hours / 10));
        mHour.setText(String.valueOf(hours % 10));
        mTensMinute.setText(String.valueOf(minutes / 10));
        mMinute.setText(String.valueOf(minutes % 10));
        mTensSecond.setText(String.valueOf(seconds / 10));
        mSecond.setText(String.valueOf(seconds % 10));
    }
}

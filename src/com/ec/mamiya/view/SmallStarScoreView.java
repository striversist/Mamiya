package com.ec.mamiya.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ec.mamiya.R;

public class SmallStarScoreView extends LinearLayout {
    
    private Context mContext;
    private float mScore;
    private ImageView mStar1;
    private ImageView mStar2;
    private ImageView mStar3;
    private ImageView mStar4;
    private ImageView mStar5;
    
    public SmallStarScoreView(Context context) {
        this(context, null, 0);
    }
    
    public SmallStarScoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public SmallStarScoreView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.small_star_score, this);
        
        mStar1 = (ImageView) findViewById(R.id.num_1);
        mStar2 = (ImageView) findViewById(R.id.num_2);
        mStar3 = (ImageView) findViewById(R.id.num_3);
        mStar4 = (ImageView) findViewById(R.id.num_4);
        mStar5 = (ImageView) findViewById(R.id.num_5);
    }
    
    public void setScore(float score) {
        assert (score >=0 && score <=5);
        mScore = score;
        update();
    }
    
    private void reset() {
        mStar1.setImageResource(R.drawable.big_star_empty);
        mStar2.setImageResource(R.drawable.big_star_empty);
        mStar3.setImageResource(R.drawable.big_star_empty);
        mStar4.setImageResource(R.drawable.big_star_empty);
        mStar5.setImageResource(R.drawable.big_star_empty);
    }
    
    private void update() {
        final float score = mScore;
        reset();
        if (score >= 0.5 && score < 1) {
            mStar1.setImageResource(R.drawable.big_star_half);
        } else if (score >= 1 && score < 1.5) {
            mStar1.setImageResource(R.drawable.big_star_full);
        } else if (score >= 1.5 && score < 2) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_half);
        } else if (score >= 2 && score < 2.5) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
        } else if (score >= 2.5 && score < 3) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_half);
        } else if (score >= 3 && score < 3.5) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_full);
        } else if (score >= 3.5 && score < 4) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_full);
            mStar4.setImageResource(R.drawable.big_star_half);
        } else if (score >= 4 && score < 4.5) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_full);
            mStar4.setImageResource(R.drawable.big_star_full);
        } else if (score >= 4.5 && score < 5) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_full);
            mStar4.setImageResource(R.drawable.big_star_full);
            mStar5.setImageResource(R.drawable.big_star_half);
        } else if (score >= 5) {
            mStar1.setImageResource(R.drawable.big_star_full);
            mStar2.setImageResource(R.drawable.big_star_full);
            mStar3.setImageResource(R.drawable.big_star_full);
            mStar4.setImageResource(R.drawable.big_star_full);
            mStar5.setImageResource(R.drawable.big_star_full);
        }
    }
}

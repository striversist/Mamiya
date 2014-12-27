package com.ec.mamiya.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ec.mamiya.R;
import com.ec.mamiya.data.ProductReview;
import com.ec.mamiya.view.BigStarScoreView;

public class ProductReviewsListAdapter extends BaseAdapter {

    private static final int VIEW_TYPE_TOTAL_SCORE = 0;
    private static final int VIEW_TYPE_REVIEW_LIST = 1;
    private Context mContext;
    private float mTotalScrore;
    private ArrayList<ProductReview> mReviews = new ArrayList<ProductReview>();
    
    public ProductReviewsListAdapter(Context context, float totalScore, ArrayList<ProductReview> reviews) {
        assert (context != null);
        assert (totalScore >= 0);
        mContext = context;
        mTotalScrore = totalScore;
        if (reviews != null) {
            mReviews.addAll(reviews);
        }
    }
    
    @Override
    public int getCount() {
        return 1 + mReviews.size();
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
    public int getViewTypeCount() {
        return 2;
    }
    
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_TOTAL_SCORE;
        } else {
            return VIEW_TYPE_REVIEW_LIST;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_TOTAL_SCORE:
                if (view == null) {
                    view = LayoutInflater.from(mContext).inflate(R.layout.product_satisfaction_view, parent, false);
                }
                BigStarScoreView scoreView = (BigStarScoreView) view.findViewById(R.id.big_score_view);
                scoreView.setScore(mTotalScrore);
                break;
            case VIEW_TYPE_REVIEW_LIST:
                if (view == null) {
                    view = LayoutInflater.from(mContext).inflate(R.layout.product_review_list_item, parent, false);
                }
                break;
        }
        return view;
    }

}

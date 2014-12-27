package com.ec.mamiya.data;

public class ProductReview {

    private float mScore;
    private String mAccount;
    private String mReview;
    private String mParams;
    
    public ProductReview(float score, String account, String review, String params) {
        mScore = score;
        mAccount = account;
        mReview = review;
        mParams = params;
    }
    
    public float getScore() {
        return mScore;
    }
    
    public String getAccount() {
        return mAccount;
    }
    
    public String getReview() {
        return mReview;
    }
    
    public String getParams() {
        return mParams;
    }
}

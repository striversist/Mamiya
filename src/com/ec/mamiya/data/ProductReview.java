package com.ec.mamiya.data;

public class ProductReview {

    private int mScore;
    private String mAccount;
    private String mReview;
    private String mParams;
    
    public ProductReview(int score, String account, String review, String params) {
        mScore = score;
        mAccount = account;
        mReview = review;
        mParams = params;
    }
    
    public int getScore() {
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

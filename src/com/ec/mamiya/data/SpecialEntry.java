package com.ec.mamiya.data;

public class SpecialEntry {

    private String mPicLink;
    private String mTitle;
    private String mLeftDay;
    private String mDiscount;
    private String mEntryLink;
    // For local test
    private int mDrawableId;
    
    public SpecialEntry(String picLink, String title, String leftDay, String discount, String entryLink) {
        assert (picLink != null);
        assert (title != null);
        assert (leftDay != null);
        assert (discount != null);
        assert (entryLink != null);
        
        mPicLink = picLink;
        mTitle = title;
        mLeftDay = leftDay;
        mDiscount = discount;
        mEntryLink = entryLink;
    }
    
    public String getPictureLink() {
        return mPicLink;
    }
    
    public String getTitle() {
        return mTitle;
    }
    
    public String getLeftDay() {
        return mLeftDay;
    }
    
    public String getDiscount() {
        return mDiscount;
    }
    
    public String getEntryLink() {
        return mEntryLink;
    }
    
    public void setDrawableId(int drawableId) {
        mDrawableId = drawableId;
    }
    
    public int getDrawableId() {
        return mDrawableId;
    }
}

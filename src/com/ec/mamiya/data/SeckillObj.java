package com.ec.mamiya.data;

public class SeckillObj {

    private String mPicLink;
    private String mTitle;
    private String mDiscount;
    private String mPrice;
    private String mEntryLink;
    
    public SeckillObj(String picLink, String title, String discount, String price, String entryLink) {
        assert (picLink != null);
        assert (title != null);
        assert (discount != null);
        assert (price != null);
        assert (entryLink != null);
        
        mPicLink = picLink;
        mTitle = title;
        mDiscount = discount;
        mPrice = price;
        mEntryLink = entryLink;
    }
    
    public String getPictureLink() {
        return mPicLink;
    }
    
    public String getTitle() {
        return mTitle;
    }
    
    public String getDiscount() {
        return mDiscount;
    }
    
    public String getPrice() {
        return mPrice;
    }
    
    public String getEntryLink() {
        return mEntryLink;
    }
}

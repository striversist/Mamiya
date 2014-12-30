package com.ec.mamiya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ec.mamiya.adapter.ProductFragmentPagerAdapter;
import com.viewpagerindicator.UnderlinePageIndicator;

public class ProductActivity extends FragmentActivity {
	
	private ViewPager mPager;
	private ProductFragmentPagerAdapter mAdapter;
	private View mDetailsPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        
        mPager = (ViewPager) findViewById(R.id.pager);
        mDetailsPicker = findViewById(R.id.details_picker);
        mAdapter = new ProductFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        
        UnderlinePageIndicator indicator = (UnderlinePageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        indicator.setFades(false);
        indicator.setSelectedColor(getResources().getColor(R.color.pink));
    }
    
    public static void startFrom(Context context) {
    	context.startActivity(new Intent(context, ProductActivity.class));
    }
    
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_cart:
                mDetailsPicker.setVisibility(View.VISIBLE);
                break;
            case R.id.cancel:
                mDetailsPicker.setVisibility(View.GONE);
                break;
        }
    }
}

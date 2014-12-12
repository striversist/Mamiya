package com.ec.mamiya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.ec.mamiya.adapter.ProductFragmentPagerAdapter;

public class ProductActivity extends FragmentActivity {
	
	private ViewPager mPager;
	private ProductFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        
        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new ProductFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
    }
    
    public static void startFrom(Context context) {
    	context.startActivity(new Intent(context, ProductActivity.class));
    }
}

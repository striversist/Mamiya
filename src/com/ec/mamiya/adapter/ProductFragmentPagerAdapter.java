package com.ec.mamiya.adapter;

import java.util.ArrayList;

import com.ec.mamiya.fragment.ProductDetailsFragment;
import com.ec.mamiya.fragment.ProductParamsFragment;
import com.ec.mamiya.fragment.ProductReviewsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProductFragmentPagerAdapter extends FragmentPagerAdapter {

	private static final int TAB_PARAMS_INDEX = 0;
	private static final int TAB_DETAILS_INDEX = 1;
	private static final int TAB_REVIEWS_INDEX = 2;
	private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();
	
	public ProductFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
		mFragmentList.add(TAB_PARAMS_INDEX, new ProductParamsFragment());
		mFragmentList.add(TAB_DETAILS_INDEX, new ProductDetailsFragment());
		mFragmentList.add(TAB_REVIEWS_INDEX, new ProductReviewsFragment());
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}

}

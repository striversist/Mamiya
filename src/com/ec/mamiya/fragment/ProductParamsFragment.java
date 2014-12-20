package com.ec.mamiya.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ec.mamiya.R;

public class ProductParamsFragment extends Fragment {
	
	public static final String TAG = "ProductParamsFragment";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    ViewGroup v = (ViewGroup) inflater.inflate(R.layout.product_tab_params, container, false);
	    
	    return v;
    }
}

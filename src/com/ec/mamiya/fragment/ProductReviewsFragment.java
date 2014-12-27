package com.ec.mamiya.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ec.mamiya.R;

public class ProductReviewsFragment extends Fragment {

	public static final String TAG = "ProductReviewsFragment";
	private ListView mListView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.product_tab_params, container, false);
	    mListView = (ListView) layout.findViewById(R.id.listview);

        return layout;
    }
}

package com.ec.mamiya.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ec.mamiya.R;
import com.ec.mamiya.adapter.ProductReviewsListAdapter;
import com.ec.mamiya.data.ProductReview;

public class ProductReviewsFragment extends Fragment {

	public static final String TAG = "ProductReviewsFragment";
	private ListView mListView;
	private ProductReviewsListAdapter mAdapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.product_tab_reviews, container, false);
	    mListView = (ListView) layout.findViewById(R.id.listview);
	    loadSampleData();
	    
        return layout;
    }
	
	private void loadSampleData() {
	    float totalScore = Float.valueOf(getResources().getString(R.string.sample_product_reviews_satisfaction_score_1));
	    ArrayList<ProductReview> reviews = new ArrayList<ProductReview>();
	    
	    float score1 = Float.valueOf(getString(R.string.sample_product_reviews_satisfaction_score_1));
	    String account1 = getString(R.string.sample_product_reviews_account_name_1);
	    String review1 = getString(R.string.sample_product_reviews_text_1);
	    String params1 = getString(R.string.sample_product_reviews_params_1);
	    ProductReview productReview1 = new ProductReview(score1, account1, review1, params1);
	    ProductReview productReview2 = new ProductReview(score1, account1, review1, params1);
	    reviews.add(productReview1);
	    reviews.add(productReview2);
	    
	    mAdapter = new ProductReviewsListAdapter(getActivity(), totalScore, reviews);
	    mListView.setAdapter(mAdapter);
	}
}

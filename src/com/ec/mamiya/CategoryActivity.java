package com.ec.mamiya;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.ec.mamiya.data.CategoryBrand;
import com.ec.mamiya.view.CategoryBrandsView;

public class CategoryActivity extends Activity {
    
    private CategoryBrandsView mBrandsView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        mBrandsView = (CategoryBrandsView) findViewById(R.id.category_brands);
        
        loadSampleData();
    }

    private void loadSampleData() {
        Integer[] logos = new Integer[] {
                R.drawable.sample_category_brand_1,
                R.drawable.sample_category_brand_2,
                R.drawable.sample_category_brand_3,
                R.drawable.sample_category_brand_4,
                R.drawable.sample_category_brand_5,
                R.drawable.sample_category_brand_6,
                R.drawable.sample_category_brand_7,
                R.drawable.sample_category_brand_8,
                R.drawable.sample_category_brand_9,
                R.drawable.sample_category_brand_10,
                R.drawable.sample_category_brand_11,
                R.drawable.sample_category_brand_12,
                R.drawable.sample_category_brand_13,
                R.drawable.sample_category_brand_14,
                R.drawable.sample_category_brand_15,
        };
        
        ArrayList<CategoryBrand> brands = new ArrayList<CategoryBrand>();
        for (Integer logo : logos) {
            CategoryBrand brand = new CategoryBrand();
            brand.drawableId = logo;
            brands.add(brand);
        }
        mBrandsView.setBrands(brands);
    }
}

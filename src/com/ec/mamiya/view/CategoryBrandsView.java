package com.ec.mamiya.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ec.mamiya.R;
import com.ec.mamiya.data.CategoryBrand;

/**
 * 注：每行3列的布局
 * @author Administrator
 *
 */
public class CategoryBrandsView extends LinearLayout {

    private static final int ROW_NUM = 5;
    private Context mContext;
    private ArrayList<View> mRows = new ArrayList<View>(ROW_NUM);
    private ArrayList<CategoryBrand> mBrands = new ArrayList<CategoryBrand>();
    
    public CategoryBrandsView(Context context) {
        this(context, null, 0);
    }
    
    public CategoryBrandsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public CategoryBrandsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.category_brands_view, this);
        mContext = context;
        View row1 = findViewById(R.id.row1);
        View row2 = findViewById(R.id.row2);
        View row3 = findViewById(R.id.row3);
        View row4 = findViewById(R.id.row4);
        View row5 = findViewById(R.id.row5);
        
        mRows.add(row1);
        mRows.add(row2);
        mRows.add(row3);
        mRows.add(row4);
        mRows.add(row5);
    }
    
    public void setBrands(ArrayList<CategoryBrand> brands) {
        assert (brands != null);
        mBrands.clear();
        mBrands.addAll(brands);
        update();
    }
    
    private void update() {
        if (mBrands.isEmpty()) 
            return;
        
        clearAll();
        int index = 0;
        for (View row : mRows) {
            CategoryBrand brand1 = null, brand2 = null, brand3 = null;
            // first
            if (index >= mBrands.size()) {
                updateRow(row, brand1, brand2, brand3);
                break;
            } else {
                brand1 = mBrands.get(index);
                index++;
            }
            // second
            if (index >= mBrands.size()) {
                updateRow(row, brand1, brand2, brand3);
                break;
            } else {
                brand2 = mBrands.get(index);
                index++;
            }
            // third
            if (index >= mBrands.size()) {
                updateRow(row, brand1, brand2, brand3);
                break;
            } else {
                brand3 = mBrands.get(index);
                index++;
            }
            updateRow(row, brand1, brand2, brand3);
        }
    }
    
    private void clearAll() {
        for (View row : mRows) {
            updateRow(row, null, null, null);
        }
    }
    
    private void updateRow(View row, CategoryBrand brand1, CategoryBrand brand2, CategoryBrand brand3) {
        ImageView view1 = (ImageView) row.findViewById(R.id.brand1);
        ImageView view2 = (ImageView) row.findViewById(R.id.brand2);
        ImageView view3 = (ImageView) row.findViewById(R.id.brand3);
        
        if (view1 != null) {
            if (brand1 == null) {
                view1.setImageBitmap(null);
            } else if (brand1.drawableId > 0) {
                view1.setImageResource(brand1.drawableId);
            }
        }
        if (view2 != null) {
            if (brand2 == null) {
                view2.setImageBitmap(null);
            } else if (brand2.drawableId > 0) {
                view2.setImageResource(brand2.drawableId);
            }
        }
        if (view3 != null) {
            if (brand3 == null) {
                view3.setImageBitmap(null);
            } else if (brand3.drawableId > 0) {
                view3.setImageResource(brand3.drawableId);
            }
        }
    }
}

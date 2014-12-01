package com.ec.mamiya;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    private TabHost mTabHost;
    private RadioGroup mTabGroup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(getLocalActivityManager());
        mTabGroup = (RadioGroup)findViewById(R.id.tab_group);
        
        mTabGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                case R.id.tab_promotion:
                    mTabHost.setCurrentTabByTag(getString(R.string.promotion));
                    break;
                case R.id.tab_category:
                    mTabHost.setCurrentTabByTag(getString(R.string.category));
                    break;
                case R.id.tab_cart:
                    mTabHost.setCurrentTabByTag(getString(R.string.cart));
                    break;
                case R.id.tab_mine:
                    mTabHost.setCurrentTabByTag(getString(R.string.mine));
                    break;
                default:
                    break;
                }
            }
        });
        
        createTabs();
    }
    
    private void createTabs() {
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.promotion))
                .setIndicator(getString(R.string.promotion))
                .setContent(new Intent(this, PromotionActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.category))
                .setIndicator(getString(R.string.category))
                .setContent(new Intent(this, CategoryActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.cart))
                .setIndicator(getString(R.string.cart))
                .setContent(new Intent(this, CartActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.mine))
                .setIndicator(getString(R.string.mine))
                .setContent(new Intent(this, MineActivity.class)));
    }
}

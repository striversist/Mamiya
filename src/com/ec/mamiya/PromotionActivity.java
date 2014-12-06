package com.ec.mamiya;

import com.ec.mamiya.adapter.SamplePromotionAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class PromotionActivity extends Activity {

    private ListView mListView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        
        mListView = (ListView) findViewById(R.id.listview);
        loadSampleData();
    }
    
    public void onMenuClicked(View view) {
        
    }
    
    public void onSearchClicked(View view) {
        
    }
    
    private void loadSampleData() {
        mListView.setAdapter(new SamplePromotionAdapter(this));
    }
}

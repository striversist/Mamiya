package com.ec.mamiya;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ec.mamiya.adapter.SamplePromotionAdapter;
import com.ec.mamiya.adapter.SamplePromotionAdapter.ViewType;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class PromotionActivity extends Activity {

    private PullToRefreshListView mPullRefreshListView;
    private SamplePromotionAdapter mAdapter;
    
    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            // TODO: Refresh UI component

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.listview);
        // Set a listener to be invoked when the list should be refreshed.
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });
        mPullRefreshListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int headerCount = mPullRefreshListView.getRefreshableView().getHeaderViewsCount();
				position -= headerCount;
				switch (ViewType.values()[mAdapter.getItemViewType(position)]) {
					case Seckill_Item:
						ProductActivity.startFrom(PromotionActivity.this);
						break;
					default:
						break;
				}
			}
		});
        
        ListView actualListView = mPullRefreshListView.getRefreshableView();
        // Need to use the Actual ListView when registering for Context Menu
        registerForContextMenu(actualListView);
        
        loadSampleData();
    }
    
    public void onMenuClicked(View view) {
        
    }
    
    public void onSearchClicked(View view) {
        
    }
    
    private void loadSampleData() {
        ListView actualListView = mPullRefreshListView.getRefreshableView();
        mAdapter = new SamplePromotionAdapter(this);
        actualListView.setAdapter(mAdapter);
    }
}

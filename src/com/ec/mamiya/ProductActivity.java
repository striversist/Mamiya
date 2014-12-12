package com.ec.mamiya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ProductActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
    
    public static void startFrom(Context context) {
    	context.startActivity(new Intent(context, ProductActivity.class));
    }
}

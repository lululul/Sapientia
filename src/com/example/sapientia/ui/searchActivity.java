package com.example.sapientia.ui;

import android.os.Bundle;
import android.view.Window;

import com.example.sapientia.R;
import com.example.sapientia.base.baseActivity;

public class searchActivity extends baseActivity {

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.search_layout);
	}
}

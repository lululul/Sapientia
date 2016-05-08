package com.examle.sapientia.fragment;

import com.example.sapientia.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class localBooksFragment extends Fragment {
	
	private View myView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		myView=inflater.inflate(R.layout.bookfragment_layout, null);
		
		return myView;
	}
}

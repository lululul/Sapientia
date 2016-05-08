package com.example.sapientia.fragment;

import com.example.sapientia.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class hookFragment extends Fragment {
	
	private View hookView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		hookView = inflater.inflate(R.layout.hook_layout, container,false);
		
		return hookView;
	}
}

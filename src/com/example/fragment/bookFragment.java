package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.sapientia.R;
import com.example.sapientia.main_acitivity;
import com.example.sapientia.reader;

import android.R.anim;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class bookFragment extends Fragment implements OnItemClickListener{

	private View myView;
	private ListView listView;
	private String[] name_book={"天龙八部","神雕侠侣","射雕英雄传","一阳指","金庸"};

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		myView = inflater.inflate(R.layout.book_layout, null);
		listView = (ListView) myView.findViewById(R.id.listbooks);
		init();
		return myView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	private void init() {
		// TODO Auto-generated method stub
		List<String> items = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			items.add(name_book[i]);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_expandable_list_item_1,items);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent("com.example.activitytext.ACTION_START");
		startActivity(intent);
	}
}
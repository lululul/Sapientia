package com.example.sapientia.fragment;

import com.example.sapientia.R;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class netFragment extends Fragment {

	private String url="http://www.baidu.com";
	private WebView web;
	private View myView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		myView=View.inflate(getActivity(), R.layout.netfragment_layout, null);
		init();
		
		return myView;
	}

	private void init() {
		// TODO Auto-generated method stub
		web=(WebView) myView.findViewById(R.id.web_book);
		web.loadUrl(url);
		web.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});
		WebSettings settings=web.getSettings();
		settings.setJavaScriptEnabled(true);
		
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
	}
}

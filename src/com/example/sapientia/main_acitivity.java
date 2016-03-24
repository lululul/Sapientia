package com.example.sapientia;

import com.example.sapientia.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fragment.ExchangeColorView;
import com.example.fragment.bookFragment;
import com.example.fragment.hookFragment;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class main_acitivity extends FragmentActivity implements
		OnPageChangeListener {

	private ExchangeColorView book;
	private ExchangeColorView hook;
	private ImageButton homebtn;
	private ViewPager myViewPager;
	private String[] mTitles = { "BOOK", "HOOK" };
	private List<ExchangeColorView> mTabIndicator = new ArrayList<ExchangeColorView>();
	private Fragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);
		init();

		myViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		NavFragmentAdapter adapter = new NavFragmentAdapter(
				getSupportFragmentManager());
		myViewPager.setAdapter(adapter);
		

		myViewPager.setOnPageChangeListener(this);
		homebtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		book.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		hook.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void init() {

		book = (ExchangeColorView) findViewById(R.id.book);
		hook = (ExchangeColorView) findViewById(R.id.hook);
		homebtn = (ImageButton) findViewById(R.id.homeBtn);


		mTabIndicator.add(book);
		mTabIndicator.add(hook);
		book.setIconAlpha(1.0f);

	}

	class NavFragmentAdapter extends FragmentPagerAdapter {

		public NavFragmentAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub

			Log.v("ew", "" + arg0);
			switch (arg0) {
			case 0:
				bookFragment f = new bookFragment();
				Bundle bundle = new Bundle();
				bundle.putString("title", mTitles[arg0]);
				f.setArguments(bundle);
				fragment = f;
				break;
			case 1:
				hookFragment f2 = new hookFragment();
				Bundle bundle1 = new Bundle();
				bundle1.putString("title", mTitles[arg0]);
				f2.setArguments(bundle1);
				fragment = f2;

				break;

			default:

				break;
			}

			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mTitles.length;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * positionOffset是划出去的偏移量
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		// TODO Auto-generated method stub
		// 监听滑动过程-->自定义控件 的颜色的透明度
		Log.v("偏移量", "" + positionOffset);
		if (positionOffset > 0) {

			ExchangeColorView left = mTabIndicator.get(position);
			ExchangeColorView right = mTabIndicator.get(position + 1);
			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
			Log.v("position", "" + position);

		}

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		// 已经选中的状态

	}

}

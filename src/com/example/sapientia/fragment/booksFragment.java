package com.example.sapientia.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.sapientia.fragment.localBooksFragment;
import com.example.sapientia.fragment.netFragment;
import com.example.sapientia.style.ExchangeColorView;
import com.example.sapientia.ui.main_activity;
import com.example.sapientia.ui.readerActivity;
import com.example.sapientia.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class booksFragment extends Fragment implements OnPageChangeListener{
	
	private View bookTitleView;
//	初始化自定义控件ExchageColorView
	private ExchangeColorView localbooks;
	private ExchangeColorView net;
//	初始化菜单ImageView
	private ImageView menu,reading;
//	初始化PopupWindow
	private ViewPager myViewPager;
	private String[] mTitles = { "BOOK", "NET" };
	private List<ExchangeColorView> mTabIndicator = new ArrayList<ExchangeColorView>();
	private Fragment fragment;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		bookTitleView=inflater.inflate(R.layout.booktitle_layout,container, false);
		
		init();

		myViewPager = (ViewPager) bookTitleView.findViewById(R.id.id_viewpager);
		NavFragmentAdapter adapter = new NavFragmentAdapter(
				getFragmentManager());
		myViewPager.setAdapter(adapter);

		myViewPager.setOnPageChangeListener(this);
		initOnClick();
		
		return bookTitleView;
	}
	private void init() {

		localbooks = (ExchangeColorView) bookTitleView.findViewById(R.id.local);
		net = (ExchangeColorView) bookTitleView.findViewById(R.id.net);
		menu = (ImageView) bookTitleView.findViewById(R.id.menu);
		reading = (ImageView) bookTitleView.findViewById(R.id.reading_book);

		mTabIndicator.add(localbooks);
		mTabIndicator.add(net);
		localbooks.setIconAlpha(1.0f);

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
				localBooksFragment f = new localBooksFragment();
				Bundle bundle = new Bundle();
				bundle.putString("title", mTitles[arg0]);
				f.setArguments(bundle);
				fragment = f;
				break;
			case 1:
				netFragment f2 = new netFragment();
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
	 * positionOffset
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		// TODO Auto-generated method stub
		Log.v("ƫ����", "" + positionOffset);
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

	}


	protected void initOnClick() {
		localbooks.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myViewPager.setCurrentItem(0);
			}
		});

		net.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myViewPager.setCurrentItem(1);
			}
		});
		
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				main_activity activity = (main_activity) getActivity();
				activity.initPopWindow();
			}
		});
		
		reading.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),readerActivity.class);
				startActivity(intent);
			}
		});
	}

}



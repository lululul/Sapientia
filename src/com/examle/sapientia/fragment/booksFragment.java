package com.examle.sapientia.fragment;

import java.util.ArrayList;
import java.util.List;
import com.examle.sapientia.fragment.localBooksFragment;
import com.examle.sapientia.fragment.netFragment;
import com.examle.sapientia.style.ExchangeColorView;
import com.example.sapientia.R;
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

public class booksFragment extends Fragment implements OnPageChangeListener{
	
	private View bookTitleView;
	private ExchangeColorView localbooks;
	private ExchangeColorView net;
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

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// // TODO Auto-generated method stub
	// if (keyCode==KeyEvent.KEYCODE_BACK) {
	// if (web.canGoBack()) {
	// web.goBack();
	// return true;
	// } else {
	// System.exit(0);
	// }
	// }
	//
	// return super.onKeyDown(keyCode, event);
	// }

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
	}

}



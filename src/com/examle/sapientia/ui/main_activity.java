package com.examle.sapientia.ui;

import java.util.ArrayList;
import com.examle.sapientia.base.baseActivity;
import com.examle.sapientia.fragment.booksFragment;
import com.examle.sapientia.fragment.hookFragment;
import com.examle.sapientia.style.NoScrollViewPager;
import com.example.sapientia.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class main_activity extends baseActivity implements OnClickListener {

	// 定义ViewPager
	private NoScrollViewPager myViewPager;
//	定义FragmentPagerAdpter
	private FragmentPagerAdapter adapter;
	private ArrayList<Fragment> list;
	// 定义Fragment页面
	private booksFragment booksFragment;
	private hookFragment hookFragment;
	// 定义布局组件
	private FrameLayout booksLayout, hookLayout;
	// 定义ImageView组件
	private ImageView booksImg, hookImg;
	// 定义按钮图片组件
	private ImageView toggleImageView, plusImageView;

	// 定义PopupWindow
	// private PopupWindow popWindow;
	// 获取手机屏幕分辨率的类
	// private DisplayMetrics dm;

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);

		initView();

		initData();
		clickBooksBtn();
		// 初始化默认为选中点击了“动态”按钮
		clickAtBtn();
	}

	private void clickAtBtn() {
		// TODO Auto-generated method stub

	}

	private void initData() {
		// TODO Auto-generated method stub
		booksLayout.setOnClickListener(this);
		hookLayout.setOnClickListener(this);

		toggleImageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.layout_books:
			clickBooksBtn();
			break;
		case R.id.layout_hook:
			clickhookBtn();
			break;
		case R.id.toggle_btn:
			clickboggleBtn();
			break;
		default:
			break;
		}
	}

	private void clickboggleBtn() {
		// TODO Auto-generated method stub
		// 实例化Fragment页面
		showPopupWindow(toggleImageView);
		// 改变按钮显示的图片为按下时的状态
		plusImageView.setSelected(true);
	}

	private void showPopupWindow(View parent) {
		// TODO Auto-generated method stub

	}

	private void clickhookBtn() {
		// TODO Auto-generated method stub
		myViewPager.setCurrentItem(1);
		
		booksLayout.setSelected(false);
		booksImg.setSelected(false);

		hookLayout.setSelected(true);
		hookImg.setSelected(true);
	}

	private void clickBooksBtn() {
		// TODO Auto-generated method stub
		// 改变选中状态
		myViewPager.setCurrentItem(0);
		
		booksLayout.setSelected(true);
		booksImg.setSelected(true);

		hookLayout.setSelected(false);
		hookImg.setSelected(false);
	}

	private void initView() {
		// TODO Auto-generated method stub
		// 实例化FrameLayout
		booksLayout = (FrameLayout) findViewById(R.id.layout_books);
		hookLayout = (FrameLayout) findViewById(R.id.layout_hook);
		// 实例化ImageView
		booksImg = (ImageView) findViewById(R.id.image_books);
		hookImg = (ImageView) findViewById(R.id.image_hook);
		// 实例化按钮图片组件
		toggleImageView = (ImageView) findViewById(R.id.toggle_btn);
		plusImageView = (ImageView) findViewById(R.id.plus_btn);

		myViewPager = (NoScrollViewPager) findViewById(R.id.frame_content);
		list = new ArrayList<Fragment>();
		booksFragment = new booksFragment();
		hookFragment = new hookFragment();
		list.add(booksFragment);
		list.add(hookFragment);
		adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return list.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return list.get(arg0);
			}
		};
		myViewPager.setAdapter(adapter);
	}
}
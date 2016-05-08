package com.example.sapientia.ui;

import java.io.File;
import java.util.ArrayList;

import com.example.sapientia.base.baseActivity;
import com.example.sapientia.file.FileManager;
import com.example.sapientia.fragment.booksFragment;
import com.example.sapientia.fragment.hookFragment;
import com.example.sapientia.style.CircleImageView;
import com.example.sapientia.style.NoScrollViewPager;
import com.example.sapientia.R;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class main_activity extends baseActivity implements OnClickListener {

//  初始化自定义NoScrollViewPager
	private NoScrollViewPager myViewPager;
//	初始化Fragment适配器FragmentPagerAdpter
	private FragmentPagerAdapter adapter;
	private ArrayList<Fragment> list;
//	初始化Fragment碎片 
	private booksFragment booksFragment;
	private hookFragment hookFragment;
//	初始化布局文件 
	private FrameLayout booksLayout, hookLayout;
// 	初始化ImageView控件
	private ImageView booksImg, hookImg;
	private ImageView toggleImageView, plusImageView;
//  初始化PopupWindow
	private PopupWindow popWindow;

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
		clickAtBtn();
		
		FileManager mFileManager = new FileManager();
		mFileManager.createSdcardDir();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			if (popWindow != null && popWindow.isShowing()) {
				popWindow.dismiss();
			}else {
				initPopWindow();
			}
			break;
		case KeyEvent.KEYCODE_BACK:
			main_activity.this.finish();
			break;
		default:
			break;
		}
		
		return true;
		
	};
	
	
	public void initPopWindow() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.menu_window, null);

//		初始化PopupWindow
		popWindow = new PopupWindow(view,
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.WRAP_CONTENT);
//		获取焦点，必须包含
		popWindow.setFocusable(true);
//		实例化一个半透明的ColorDrawable
		ColorDrawable dw = new ColorDrawable(0xb00f0f0f);
		popWindow.setBackgroundDrawable(dw);
//		为popupwindow设置显示和消失的动画
		popWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//		设置PopupWindow显示的位置
		popWindow.showAtLocation(
				main_activity.this.findViewById(R.id.menu),
				Gravity.BOTTOM, 0, 0);
//		为PopupWindow里面的控件设置点击事件
		Button FirstMenu = (Button) view.findViewById(R.id.menu_first);
		Button secMenu = (Button) view.findViewById(R.id.id_logout);
		Button cancelMenu = (Button) view.findViewById(R.id.menu_cancel);
		
		FirstMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub 
				openActivity(settingActivity.class);
				popWindow.dismiss();
			}
		});
		
		secMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File f=new File("/data/data/com.example.sapientia/shared_prefs/data.xml");
				delFile(f);
				popWindow.dismiss();
			}
		});
		
		cancelMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				popWindow.dismiss();
			}
		});
	}

	
	private void delFile(File file) {
		// TODO Auto-generated method stub
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			}else if(file.isDirectory()){
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					this.delFile(files[i]);
				}
			}
			file.delete();
		}else {
			Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
		}
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
		showPopupWindow();
	}

	private void showPopupWindow() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.send_window, null);

//		初始化PopupWindow
		popWindow = new PopupWindow(view,
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT);
//		获取焦点，必须包含
		popWindow.setFocusable(true);
//		实例化一个半透明的ColorDrawable
		ColorDrawable dw = new ColorDrawable(0xb0ffffff);
		popWindow.setBackgroundDrawable(dw);
//		为popupwindow设置显示和消失的动画
		popWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//		设置PopupWindow显示的位置
		popWindow.showAtLocation(
				main_activity.this.findViewById(R.id.toggle_btn),
				Gravity.BOTTOM, 0, 0);
		CircleImageView send = (CircleImageView) view.findViewById(R.id.send_hook);
		CircleImageView upload = (CircleImageView) view.findViewById(R.id.upload_books);
		ImageView cancelView = (ImageView) view.findViewById(R.id.plus_btn2);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openActivity(sendStateActivity.class);
			}
		});
		
		upload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cancelView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popWindow.dismiss();
			}
		});
	}

	private void clickhookBtn() {
		// TODO Auto-generated method stub
		myViewPager.setCurrentItem(1);
		
		booksLayout.setSelected(false);
		booksImg.setSelected(false);

		hookLayout.setSelected(true);
		hookImg.setSelected(true);
	}

	/*
	 * 点击
	 */
	private void clickBooksBtn() {
		// TODO Auto-generated method stub
		myViewPager.setCurrentItem(0);
		
		booksLayout.setSelected(true);
		booksImg.setSelected(true);

		hookLayout.setSelected(false);
		hookImg.setSelected(false);
	}

	private void initView() {
		// TODO Auto-generated method stub
		// 获取各个控件
		booksLayout = (FrameLayout) findViewById(R.id.layout_books);
		hookLayout = (FrameLayout) findViewById(R.id.layout_hook);
		booksImg = (ImageView) findViewById(R.id.image_books);
		hookImg = (ImageView) findViewById(R.id.image_hook);
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
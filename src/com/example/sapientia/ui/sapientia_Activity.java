package com.example.sapientia.ui;

import java.io.File;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.example.sapientia.R;
import com.example.sapientia.base.baseActivity;


/*
 * 初始化程序（程序入口）
 */
public class sapientia_Activity extends baseActivity {

	private ImageView mSpientiaItem_iv;
	private ImageView mSpientiaBg_iv;
	private Button loginBtn;
	private Button signBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.sapientia_layout);

		findViewById();
		
//		判断是否存在账户，如果存在账户则直接登录；否则初始化登录注册按钮
		if (fileExists()) {
			loginBtn.setVisibility(View.GONE);
			signBtn.setVisibility(View.GONE);
//			设置动画效果
			initAnim();
		}else {
			mSpientiaBg_iv.setVisibility(View.GONE);;
			mSpientiaItem_iv.setVisibility(View.GONE);
		}
//		初始化button点击效果
		initBtn();	
	}

	protected void initBtn() {
		// TODO Auto-generated method stub
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				调用openActivity方法打开登录界面
				openActivity(loginActivity.class);
			}
		});
		signBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				调用openActivity方法代开注册界面
				openActivity(signUpActivity.class);
			}
		});
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.example.sapientia.base.baseActivity#findViewById()
	 */
	
	
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		mSpientiaItem_iv = (ImageView) findViewById(R.id.sapientia_loading_item);
		mSpientiaBg_iv=(ImageView) findViewById(R.id.sapientia_loading_bg);
		loginBtn = (Button) findViewById(R.id.login);
		signBtn = (Button) findViewById(R.id.sign);
	}

	/*
	 * 设置初始界面的translate动画效果
	 */
	protected void initAnim() {
		// TODO Auto-generated method stub
		Animation translate = AnimationUtils.loadAnimation(this,
				R.anim.sapientia_loading);
		translate.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
//				打开程序主界面
				openActivity(main_activity.class);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
//				结束当前sapientia_Activity
				sapientia_Activity.this.finish();
			}
		});
		mSpientiaItem_iv.setAnimation(translate);
	}
	
	/*
	 * 	判断data.xml文件是否存在
	 */

	public Boolean fileExists() {
		try {
			File f=new File("/data/data/com.example.sapientia/shared_prefs/data.xml");
			if (f.exists()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
		return false;
	}
}

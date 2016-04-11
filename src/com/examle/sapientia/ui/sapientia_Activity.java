package com.examle.sapientia.ui;

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

import com.examle.sapientia.base.baseActivity;
import com.example.sapientia.R;

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
		
		if (fileExists()) {
			loginBtn.setVisibility(View.GONE);
			signBtn.setVisibility(View.GONE);
			initAnim();
		}else {
			mSpientiaBg_iv.setVisibility(View.GONE);;
			mSpientiaItem_iv.setVisibility(View.GONE);
		}
		initBtn();	
	}

	protected void initBtn() {
		// TODO Auto-generated method stub
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openActivity(loginActivity.class);
			}
		});
		signBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openActivity(signUpActivity.class);
			}
		});
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		mSpientiaItem_iv = (ImageView) findViewById(R.id.sapientia_loading_item);
		mSpientiaBg_iv=(ImageView) findViewById(R.id.sapientia_loading_bg);
		loginBtn = (Button) findViewById(R.id.login);
		signBtn = (Button) findViewById(R.id.sign);
	}

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
				openActivity(main_activity.class);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
				sapientia_Activity.this.finish();
			}
		});
		mSpientiaItem_iv.setAnimation(translate);
	}
	
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

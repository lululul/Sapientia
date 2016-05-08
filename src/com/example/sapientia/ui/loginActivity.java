package com.example.sapientia.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sapientia.base.baseActivity;
import com.example.sapientia.R;

public class loginActivity extends baseActivity {

	private EditText user;
	private EditText password;
	private Button loginBtn;
	private TextView question;
	private TextView flesh;
	private CheckBox autologin;
	private CheckBox autoRemBox;

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		user = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.password);
		loginBtn = (Button) findViewById(R.id.ques_first);
		question = (TextView) findViewById(R.id.question);
		flesh = (TextView) findViewById(R.id.flesh);
		autologin = (CheckBox) findViewById(R.id.autologin);
		autoRemBox = (CheckBox) findViewById(R.id.autoRem);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
//		绑定控件
		findViewById();
//		为控件设置点击效果
		initOnclick();
	}

	protected void initOnclick() {
		// TODO Auto-generated method stub
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SharedPreferences preferences = getSharedPreferences("data",
						MODE_PRIVATE);
				String username = preferences.getString("user", "");
				String userpwd = preferences.getString("password", "");

				if (username.equals(user.getText().toString())) {
					if (userpwd.equals(password.getText().toString())) {
						// autoCheck();

						openActivity(main_activity.class);
						loginActivity.this.finish();
					} else {
						Toast.makeText(loginActivity.this, "密码输入有误",
								Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(loginActivity.this, "用户输入有误",
							Toast.LENGTH_SHORT).show();
				}
			}

			// private void autoCheck() {
			// // TODO Auto-generated method stub
			// if (autologin.isChecked()) {
			// autoRemBox.setChecked(true);
			// }else if (autoRemBox.isChecked()) {
			//
			// }
			// }
		});

		question.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showPopupWindow();
			}
		});

		flesh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openActivity(signUpActivity.class);
				loginActivity.this.finish();
			}
		});
	}

	/*
	 * 产生PopuoWindow的方法
	 */
	PopupWindow window;
	
	private void showPopupWindow() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.question_popupwindow, null);

//		初始化PopupWindow
		window = new PopupWindow(view,
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.WRAP_CONTENT);
//		获取焦点，必须包含
		window.setFocusable(true);
//		实例化一个半透明的ColorDrawable
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		window.setBackgroundDrawable(dw);
//		为popupwindow设置显示和消失的动画
		window.setAnimationStyle(R.style.mypopwindow_anim_style);
//		设置PopupWindow显示的位置
		window.showAtLocation(
				loginActivity.this.findViewById(R.id.question),
				Gravity.BOTTOM, 0, 0);
//		为PopupWindow里面的控件设置点击事件
		Button FirstQues = (Button) view.findViewById(R.id.ques_first);
		Button secQues = (Button) view.findViewById(R.id.ques_second);
		Button cancelQues = (Button) view.findViewById(R.id.ques_cancel);
		
		FirstQues.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				window.dismiss();
			}
		});
		
		secQues.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:15975171563"));
				startActivity(intent);
				
				window.dismiss();
			}
		});
		/*
		 * 退出popupwindow
		 */
		cancelQues.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				window.dismiss();
			}
		});
	}


}

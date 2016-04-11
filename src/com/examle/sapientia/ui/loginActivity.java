package com.examle.sapientia.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examle.sapientia.base.baseActivity;
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
		loginBtn = (Button) findViewById(R.id.button1);
		question = (TextView) findViewById(R.id.question);
		flesh = (TextView) findViewById(R.id.flesh);
		autologin=(CheckBox) findViewById(R.id.autologin);
		autoRemBox= (CheckBox) findViewById(R.id.autoRem);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);

		findViewById();

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
//						autoCheck();
						
						openActivity(main_activity.class);
						loginActivity.this.finish();
					}
					Toast.makeText(loginActivity.this, "密码错误，请重新输入",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(loginActivity.this, "账户不存在，请重新输入",
							Toast.LENGTH_SHORT).show();
				}
			}

//			private void autoCheck() {
//				// TODO Auto-generated method stub
//				if (autologin.isChecked()) {
//					autoRemBox.setChecked(true);
//				}else if (autoRemBox.isChecked()) {
//					
//				}
//			}
		});

		question.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
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

}

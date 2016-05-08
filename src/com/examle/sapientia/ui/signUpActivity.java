package com.examle.sapientia.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.examle.sapientia.base.baseActivity;
import com.example.sapientia.R;

public class signUpActivity extends baseActivity implements OnClickListener {

	private Button btn;
	private EditText user;
	private EditText phone;
	private EditText mail;
	private EditText password;
	private EditText confirmPassowrd;

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		
		user = (EditText) findViewById(R.id.userTxt);
		phone = (EditText) findViewById(R.id.phoneTxt);
		mail = (EditText) findViewById(R.id.mailTxt);
		password = (EditText) findViewById(R.id.pwdTxt);
		confirmPassowrd = (EditText) findViewById(R.id.confirmTxt);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_layout);
		
		findViewById();
		
		btn=(Button) findViewById(R.id.button1);
	    btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
//		if (stringNotEmpty()) {
			SharedPreferences.Editor editor = getSharedPreferences("data",
					MODE_PRIVATE).edit();
			editor.putString("user", user.getText().toString());
			editor.putString("phone", phone.getText().toString());
			editor.putString("mail", mail.getText().toString());
			editor.putString("password", password.getText().toString());
			editor.commit();
			signUpActivity.this.finish();
//		}
	}

	protected boolean stringNotEmpty() {
		if (!TextUtils.isEmpty(user.getText())) {
			Toast.makeText(this, "�û�������Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		} else if (!TextUtils.isEmpty(phone.getText())) {
			Toast.makeText(this, "�ֻ����벻��Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		} else if (!TextUtils.isEmpty(mail.getText())) {
			Toast.makeText(this, "�����ַ����Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		} else if (!TextUtils.isEmpty(password.getText())) {
			Toast.makeText(this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		} else if (!TextUtils.isEmpty(confirmPassowrd.getText())
				&& password.getText().equals(confirmPassowrd.getText())) {
			Toast.makeText(this, "����ȷ������", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}
}

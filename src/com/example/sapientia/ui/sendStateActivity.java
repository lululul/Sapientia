package com.example.sapientia.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sapientia.R;
import com.example.sapientia.base.baseActivity;

public class sendStateActivity extends baseActivity {

	private TextView cancelTxt;
	private ImageView sendImg;
	private EditText editArea;
	private RelativeLayout addBook,addPic;
	
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.circle_state_layout);
		
		initView();
		initOnClick();
	}

	private void initOnClick() {
		// TODO Auto-generated method stub
		cancelTxt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendStateActivity.this.finish();
			}
		});
		
		sendImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addBook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		addPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent intent = Intent("MediaStore.ACTION_IMAGE_CAPTURE");
			}
		});
	}

	private void initView() {
		// TODO Auto-generated method stub
		cancelTxt = (TextView) findViewById(R.id.stateCancel);
		sendImg = (ImageView) findViewById(R.id.stateSend);
		editArea = (EditText) findViewById(R.id.stateTxt);
		addBook=(RelativeLayout) findViewById(R.id.addbook);
		addPic = (RelativeLayout) findViewById(R.id.addPic);
	}
}

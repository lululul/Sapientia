package com.example.sapientia.config;

import android.os.Environment;

public class constants {
	public static final String SD_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	//SDcard·��
	public static final String BASE_PATH = SD_PATH + "/iTau/sapientia/";
	
	// ����ͼƬ·��
	public static final String BASE_IMAGE_CACHE = BASE_PATH + "cache/images/";

	 // ��Ҫ�����ͼƬ
	 public static final String SHARE_FILE = BASE_PATH + "QrShareImage.png";
}

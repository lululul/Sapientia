package com.example.sapientia.config;

import android.os.Environment;

public class constants {
	public static final String SD_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath();

	//SDcard路徑
	public static final String BASE_PATH = SD_PATH + "/iTau/sapientia/";
	
	// 缓存图片路径
	public static final String BASE_IMAGE_CACHE = BASE_PATH + "cache/images/";

	 // 需要分享的图片
	 public static final String SHARE_FILE = BASE_PATH + "QrShareImage.png";
}

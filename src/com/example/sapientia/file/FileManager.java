package com.example.sapientia.file;

import java.io.File;

import android.os.Environment;

public class FileManager {
	
	public FileManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void createSdcardDir() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File SDcardDir = Environment.getExternalStorageDirectory();
			String path = SDcardDir.getPath() + "/sapientia/imgs";
			File imgPath = new File(path);
			if (!imgPath.exists()) {
				imgPath.mkdirs();
			}
		}
	}
}

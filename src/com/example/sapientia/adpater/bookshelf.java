package com.example.sapientia.adpater;

public class bookshelf {
	
	private int imgID;
	private String introduce;
	private String booksName;
	
	public bookshelf(int imgId,String name,String intro) {
		// TODO Auto-generated constructor stub
		imgID=imgId;
		introduce=intro;
		booksName = name;
	}
	
	public int getImgID() {
		return imgID;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	
	public String getBooksName() {
		return booksName;
	}
}

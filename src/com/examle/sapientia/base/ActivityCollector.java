package com.examle.sapientia.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

public class ActivityCollector {
	
    public static Stack<Activity> myActsStack;
    public static ActivityCollector activityCollector;
    
    public ActivityCollector() {
		// TODO Auto-generated constructor stub
	}
    
    /**
     * 		��ȡһ��Activityʵ��
     */
    public static ActivityCollector getInstance(){
		if (activityCollector==null) {
			activityCollector=new ActivityCollector();
		}
    	
    	return activityCollector;
    	
    }
	
    
    /**
     * 		��Activity��ӵ�ջ��    
     */
	public static void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		if (myActsStack==null) {
			myActsStack=new Stack<Activity>();
		}
		myActsStack.add(activity);
	}
	
	/**
	    *     ��ȡջ��Activity
	    */
	public static Activity getTopActivity() {
		Activity activity=myActsStack.lastElement();
		
		return activity;
	}
	
	/**
	    *     ����һ��Activity
	    */
    public static void killActivity(Activity activity) {
		// TODO Auto-generated method stub
    	if (activity!=null) {
    		myActsStack.remove(activity);
    		activity.finish();
    		activity=null;
		}
	}
    
    
    /**
     *     ����ջ��Activity
     */
    public static void killTopActivity() {
    	Activity activity=myActsStack.lastElement();
    	killActivity(activity);
	}
    
    /**
     *     ��������Acitivity
     */
    public static void finishAll() {
		// TODO Auto-generated method stub
    	int size=myActsStack.size();
    	for (int i = 0 ; i < size ; i++) {
			if (null != myActsStack.get(i)) {
				myActsStack.get(i).finish();
			}
		}
    	myActsStack.clear();
	}
    
   /**
    *     �˳�����
    */
    public static void appExit(Context context){
    	try {
    		finishAll();
        	ActivityManager manager=(ActivityManager) 
        			context.getSystemService(Context.ACTIVITY_SERVICE);
        	manager.restartPackage(context.getPackageName());
        	System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}

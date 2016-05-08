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
     * 		获取一个Activity实例
     */
    public static ActivityCollector getInstance(){
		if (activityCollector==null) {
			activityCollector=new ActivityCollector();
		}
    	
    	return activityCollector;
    	
    }
	
    
    /**
     * 		把Activity添加到栈中    
     */
	public static void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		if (myActsStack==null) {
			myActsStack=new Stack<Activity>();
		}
		myActsStack.add(activity);
	}
	
	/**
	    *     获取栈顶Activity
	    */
	public static Activity getTopActivity() {
		Activity activity=myActsStack.lastElement();
		
		return activity;
	}
	
	/**
	    *     结束一个Activity
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
     *     结束栈顶Activity
     */
    public static void killTopActivity() {
    	Activity activity=myActsStack.lastElement();
    	killActivity(activity);
	}
    
    /**
     *     结束所有Acitivity
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
    *     退出程序
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

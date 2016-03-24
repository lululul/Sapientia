package com.example.fragment;

import com.example.sapientia.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ExchangeColorView extends View {
	private Bitmap iconBmp;
	private String myText;
	private float myTextSize;// 文本的大小
	private int myColor = 0xff9966;
	private Paint myTextPaint;// 画笔
	private Rect mTextBounds = new Rect();// 矩形
	private Rect mIconRect;// 设置图片的矩形区域
	private float mAlpha = 0;
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Paint mPaint;
	private Bitmap mBitmap2;
	private Canvas mCanvas2;
	private int Tleft;
	private int Theight;
	
	public ExchangeColorView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 接收自定义的属性值
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.ChangColorIconView);

		for (int i = 0; i < a.getIndexCount(); i++) {
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.ChangColorIconView_icon:
				BitmapDrawable bd = (BitmapDrawable) a.getDrawable(attr);
				iconBmp = bd.getBitmap();

				break;
			case R.styleable.ChangColorIconView_text:
				myText = a.getString(attr);

				break;
			case R.styleable.ChangColorIconView_text_size:
				myTextSize = a.getDimension(attr, 10);

				break;
			case R.styleable.ChangColorIconView_color:
				// 没有作用因为没有在xml布局中为自定义Color赋值所以这里用上面的myColor赋初值替代了
				// myColor= a.getColor(attr,0xcccc33);

				break;

			default:
				break;
			}
		}

		a.recycle();

		// 初始化画笔
		myTextPaint = new Paint();
		myTextPaint.setColor(0xff555555);
		myTextPaint.setTextSize(myTextSize);
		// 得到文字的矩形区域的宽高getTextBounds的值返回到第四个参数bounds
		myTextPaint.getTextBounds(myText, 0, myText.length(), mTextBounds);
	}

	// onMeasure是在测量里面的子控件调用
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		/**
		 * 
		 * 的到图片的高度：图片的宽高一样
		 */
		// 图片的宽高度
		int bitmapWidth = Math.min(getMeasuredWidth() - getPaddingLeft()
				- getPaddingRight(), getMeasuredHeight() - getPaddingBottom()
				- getPaddingTop());

		int left = getMeasuredWidth() / 2 - bitmapWidth / 2;
		int top = (getMeasuredHeight() - mTextBounds.height()) / 2
				- bitmapWidth / 2;
		Tleft = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - mTextBounds
				.width()) / 2;
		// 由于文字与图片是可以重叠的所以Y轴坐标是以下
		Theight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
		// 设置图片的矩形区域
		// Log.v("mText高低", ""+mTextBounds.height());
		// Log.v("Theight高低", ""+Theight);
		// Log.v("图片高低", ""+bitmapWidth);
		mIconRect = new Rect(left, top, left + bitmapWidth, top + bitmapWidth);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		/**
		 * 0.清空画板 1.先绘制矩形颜色块 2.再绘制图片 3.绘制文字
		 */
		// 清空画板
		canvas.drawBitmap(iconBmp, null, mIconRect, null);
		// 1.先绘制矩形颜色块
		// ceil向上取整
		int alpha = (int) Math.ceil(255 * mAlpha);
		setBitmap(alpha);
		// 2.再绘制图片
		// 3.绘制文字
		// 3.1绘制黑色文字--控制alpha透明
		drawSrcText(canvas, alpha);
		// 3.2绘制绿色 文字--控制透明度
		drawDstText(canvas, alpha);
		canvas.drawBitmap(mBitmap, 0, 0, null);

	}

	private void drawDstText(Canvas canvas, int alpha) {
		// TODO Auto-generated method stub
		Paint ssPaint = new Paint();

		ssPaint.setColor(0xff996600);
		ssPaint.setTextSize(myTextSize);
		// 防锯齿
		ssPaint.setAntiAlias(true);
		// 防抖动
		ssPaint.setDither(true);
		ssPaint.setAlpha(alpha);

		canvas.drawText(myText, Tleft, Theight + 2, ssPaint);

	}

	private void drawSrcText(Canvas canvas, int alpha) {
		// TODO Auto-generated method stub
		mBitmap2 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
				Config.ARGB_8888);
		mCanvas2 = new Canvas(mBitmap2);
		// 防锯齿
		myTextPaint.setAntiAlias(true);
		// 防抖动
		myTextPaint.setDither(true);
		Log.v("sss", "" + alpha);
		myTextPaint.setAlpha(255 - alpha);

		mCanvas2.drawText(myText, Tleft, Theight + 2, myTextPaint);

		canvas.drawBitmap(mBitmap2, 0, 0, null);

	}

	private void setBitmap(int alpha) {
		// TODO Auto-generated method stub

		// 绘制图片
		// 二级缓存图--先在内存的画板上面绘制好再刷新到自定义
		mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
				Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
		mPaint = new Paint();
		// 先绘制颜色块
		mPaint.setColor(myColor);
		// 防锯齿
		mPaint.setAntiAlias(true);
		// 防抖动
		mPaint.setDither(true);
		// 设置透明度
		mPaint.setAlpha(alpha);

		mCanvas.drawRect(mIconRect, mPaint);
		mPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		// mPaint.setAlpha(255);
		mCanvas.drawBitmap(iconBmp, null, mIconRect, mPaint);

		// 再绘制图片

	}

	public void setIconAlpha(float offset) {
		// TODO Auto-generated method stub
		this.mAlpha = offset;
		// 让自定义控件刷新
		invalidate();
	}

}

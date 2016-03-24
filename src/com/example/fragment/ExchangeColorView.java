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
	private float myTextSize;// �ı��Ĵ�С
	private int myColor = 0xff9966;
	private Paint myTextPaint;// ����
	private Rect mTextBounds = new Rect();// ����
	private Rect mIconRect;// ����ͼƬ�ľ�������
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
		// �����Զ��������ֵ
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
				// û��������Ϊû����xml������Ϊ�Զ���Color��ֵ���������������myColor����ֵ�����
				// myColor= a.getColor(attr,0xcccc33);

				break;

			default:
				break;
			}
		}

		a.recycle();

		// ��ʼ������
		myTextPaint = new Paint();
		myTextPaint.setColor(0xff555555);
		myTextPaint.setTextSize(myTextSize);
		// �õ����ֵľ�������Ŀ��getTextBounds��ֵ���ص����ĸ�����bounds
		myTextPaint.getTextBounds(myText, 0, myText.length(), mTextBounds);
	}

	// onMeasure���ڲ���������ӿؼ�����
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		/**
		 * 
		 * �ĵ�ͼƬ�ĸ߶ȣ�ͼƬ�Ŀ��һ��
		 */
		// ͼƬ�Ŀ�߶�
		int bitmapWidth = Math.min(getMeasuredWidth() - getPaddingLeft()
				- getPaddingRight(), getMeasuredHeight() - getPaddingBottom()
				- getPaddingTop());

		int left = getMeasuredWidth() / 2 - bitmapWidth / 2;
		int top = (getMeasuredHeight() - mTextBounds.height()) / 2
				- bitmapWidth / 2;
		Tleft = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - mTextBounds
				.width()) / 2;
		// ����������ͼƬ�ǿ����ص�������Y������������
		Theight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
		// ����ͼƬ�ľ�������
		// Log.v("mText�ߵ�", ""+mTextBounds.height());
		// Log.v("Theight�ߵ�", ""+Theight);
		// Log.v("ͼƬ�ߵ�", ""+bitmapWidth);
		mIconRect = new Rect(left, top, left + bitmapWidth, top + bitmapWidth);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		/**
		 * 0.��ջ��� 1.�Ȼ��ƾ�����ɫ�� 2.�ٻ���ͼƬ 3.��������
		 */
		// ��ջ���
		canvas.drawBitmap(iconBmp, null, mIconRect, null);
		// 1.�Ȼ��ƾ�����ɫ��
		// ceil����ȡ��
		int alpha = (int) Math.ceil(255 * mAlpha);
		setBitmap(alpha);
		// 2.�ٻ���ͼƬ
		// 3.��������
		// 3.1���ƺ�ɫ����--����alpha͸��
		drawSrcText(canvas, alpha);
		// 3.2������ɫ ����--����͸����
		drawDstText(canvas, alpha);
		canvas.drawBitmap(mBitmap, 0, 0, null);

	}

	private void drawDstText(Canvas canvas, int alpha) {
		// TODO Auto-generated method stub
		Paint ssPaint = new Paint();

		ssPaint.setColor(0xff996600);
		ssPaint.setTextSize(myTextSize);
		// �����
		ssPaint.setAntiAlias(true);
		// ������
		ssPaint.setDither(true);
		ssPaint.setAlpha(alpha);

		canvas.drawText(myText, Tleft, Theight + 2, ssPaint);

	}

	private void drawSrcText(Canvas canvas, int alpha) {
		// TODO Auto-generated method stub
		mBitmap2 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
				Config.ARGB_8888);
		mCanvas2 = new Canvas(mBitmap2);
		// �����
		myTextPaint.setAntiAlias(true);
		// ������
		myTextPaint.setDither(true);
		Log.v("sss", "" + alpha);
		myTextPaint.setAlpha(255 - alpha);

		mCanvas2.drawText(myText, Tleft, Theight + 2, myTextPaint);

		canvas.drawBitmap(mBitmap2, 0, 0, null);

	}

	private void setBitmap(int alpha) {
		// TODO Auto-generated method stub

		// ����ͼƬ
		// ��������ͼ--�����ڴ�Ļ���������ƺ���ˢ�µ��Զ���
		mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
				Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
		mPaint = new Paint();
		// �Ȼ�����ɫ��
		mPaint.setColor(myColor);
		// �����
		mPaint.setAntiAlias(true);
		// ������
		mPaint.setDither(true);
		// ����͸����
		mPaint.setAlpha(alpha);

		mCanvas.drawRect(mIconRect, mPaint);
		mPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		// mPaint.setAlpha(255);
		mCanvas.drawBitmap(iconBmp, null, mIconRect, mPaint);

		// �ٻ���ͼƬ

	}

	public void setIconAlpha(float offset) {
		// TODO Auto-generated method stub
		this.mAlpha = offset;
		// ���Զ���ؼ�ˢ��
		invalidate();
	}

}

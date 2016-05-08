package com.example.sapientia.adpater;

import java.util.List;

import com.example.sapientia.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class booksAdapter extends BaseAdapter{

	private List<bookshelf> mList;
	private LayoutInflater mInflater;
	
	public booksAdapter(Context context, List<bookshelf> list) {
		// TODO Auto-generated constructor stub
		mList = list;
		mInflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public bookshelf getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		bookshelf books=getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = mInflater.inflate(R.layout.item, null);
			viewHolder=new ViewHolder();
			viewHolder.bookImg=(ImageView) view.findViewById(R.id.list_img);
			viewHolder.bookView=(TextView) view.findViewById(R.id.list_txt);
			viewHolder.bookName=(TextView) view.findViewById(R.id.list_name);
			 view.setTag(viewHolder);
		}else {
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();
		}
		
		viewHolder.bookImg.setImageResource(mList.get(position).getImgID());
		viewHolder.bookView.setText(mList.get(position).getIntroduce());
		viewHolder.bookName.setText(mList.get(position).getBooksName());
		
		return view;
	}
	
	class ViewHolder{
		ImageView bookImg;
		TextView bookView;
		TextView bookName;
	}

}

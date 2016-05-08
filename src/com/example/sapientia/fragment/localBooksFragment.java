package com.example.sapientia.fragment;

import java.util.ArrayList;
import com.example.sapientia.R;
import com.example.sapientia.adpater.booksAdapter;
import com.example.sapientia.adpater.bookshelf;
import com.example.sapientia.ui.readerActivity;
import com.example.sapientia.ui.searchActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class localBooksFragment extends Fragment implements OnItemClickListener{

	private View myView = null;
	private ListView localBooks = null;
	private booksAdapter adapter = null;
	private EditText search = null;
	private ArrayList<bookshelf> listBooks = new ArrayList<bookshelf>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		myView = inflater.inflate(R.layout.bookfragment_layout, null);

		initBooks();
		localBooks = (ListView) myView.findViewById(R.id.local_books);
		search = (EditText) myView.findViewById(R.id.search);
		
		adapter = new booksAdapter(getActivity(), listBooks);

		localBooks.setAdapter(adapter);
		localBooks.setOnItemClickListener(this);
		
		search.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),searchActivity.class);
				startActivity(intent);
			}
		});
		return myView;
	}
	
//	初始化数据源
	
	private void initBooks() {
		// TODO Auto-generated method stub
		bookshelf poem = new bookshelf(R.drawable.add, "诗集","我问佛：为何不给所有女子羞花闭月的容颜？ ");
		listBooks.add(poem);
		bookshelf strayBirds = new bookshelf(R.drawable.sapientia_bg, "飞鸟集", "那些把灯背在背上的人，把他们的影子投到了自己前面.");
		listBooks.add(strayBirds);
	}
	
//	为每一个listview项设置点击事件
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		bookshelf book = listBooks.get(arg2);
		Intent intent = new Intent(getActivity(),readerActivity.class);
		startActivity(intent);
	}

}

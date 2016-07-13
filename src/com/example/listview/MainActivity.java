package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	private String[] mListType = { "[姓名]", "[性别]", "[年龄]", "[居住地]", "[邮箱]" };
	private String[] time = { "1小时前", "2小时前", "小时前", "昨天", "前天" };
	private String[] mListTitle = { "雨松MOMO", "男", "25", "北京", "xuan@gmail.com" };
	private String[] mListStr = { "上次查看时间", "上次查看时间", "上次查看时间", "上次查看时间", "上次查看时间" };
	private int[] images = {  R.drawable.ic_login_qq,  R.drawable.ic_account,  R.drawable.ic_launcher,  R.drawable.ic_login_qq,  R.drawable.ic_login_99};
	ListView mListView = null;
	ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//	    setContentView(R.layout.activity_main);
	    
	    
		mListView = (ListView) findViewById(R.id.lv_test);
		int lengh = mListTitle.length;
		for (int i = 0; i < lengh; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", images[i]);
			item.put("type", mListType[i]);
			item.put("title", mListTitle[i]);
			item.put("text", mListStr[i]);
			item.put("time", time[i]);
			mData.add(item);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, mData, R.layout.activity_main,
				new String[] {"image","type","title", "text","time" },
				new int[]{R.id.image,R.id.type,R.id.title,R.id.text,R.id.time});
		mListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Toast.makeText(MainActivity.this, "您选择了标题：" + mListTitle[position] + "内容：" + mListStr[position],
						Toast.LENGTH_LONG).show();
			}
		});
		setContentView(mListView);
	}
	
	public class TestAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public void onClick(View view) {
//		ListView listView = (ListView)findViewById(R.id.list);
//		String items = "Selected items:\n";
//		for (int i = 0; i < listView.getCount(); i++) {
//			if (listView.isItemChecked(i)) {
//				items += listView.getItemAtPosition(i) + "\n";
//			}
//		}
//		Toast.makeText(this, items, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

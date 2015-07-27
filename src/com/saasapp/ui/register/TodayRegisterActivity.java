package com.saasapp.ui.register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.saasapp.common.ElasticTouchListener;
import com.saasapp.common.FilterAdapter;
import com.saasapp.common.SimulatedData;
import com.saasapp.ui.R;

public class TodayRegisterActivity extends Activity {

	private Button selectDep;
	private Button myDoc;
	private Button regReturn;
	private AutoCompleteTextView autoComplete;
	private FilterAdapter<String> adapter = null;
	private Map<String, String> map = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置标题不可见
		View view = getLayoutInflater().inflate(R.layout.reg_todayreg, null);
		view.setOnTouchListener(new ElasticTouchListener());
		setContentView(view);
		selectDep = (Button) findViewById(R.id.todayreg_selectdept);
		selectDep.setOnClickListener(new SelDepClick());
		myDoc = (Button) findViewById(R.id.todayreg_mydoc);
		myDoc.setOnClickListener(new MyDocClick());
		regReturn = (Button) findViewById(R.id.todayreg_return);
		regReturn.setOnClickListener(new OnReturn());
		autoComplete = (AutoCompleteTextView) findViewById(R.id.todayreg_autocomplete);
		autoComplete.setThreshold(1);
		autoComplete.setOnItemClickListener(new OnAutoCompleteItem());

		BindData();
	}

	public void BindData() {
		map = new SimulatedData().GetDeptNameAndDocName();
		List<String> listStr = new ArrayList<String>();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			listStr.add(iterator.next().getKey());
		}
		adapter = new FilterAdapter<String>(this,
				R.layout.reg_todayreg_autocomplete, listStr);
		autoComplete.setAdapter(adapter);
	}

	class OnAutoCompleteItem implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// Object obj = parent.getItemAtPosition(position); //获取对象
//			 Log.d("TAG", "name:" + adapter.getItem(position));// 获取string
//			 Log.d("TAG", "type:" + map.get(adapter.getItem(position)));
			Intent intent=new Intent();
			 String name=adapter.getItem(position);
			 String type=map.get(name);
			 if(type.equals("Doctor")){
				 intent.setClass(TodayRegisterActivity.this,RegTimeActivity.class);
				 intent.putExtra("DocName", name);
				 intent.putExtra("DocPic", "");
				 intent.putExtra("DocTitle", "");
				 intent.putExtra("DocIntroduction", "");
			 }else if(type.equals("Department")){
				 intent.setClass(TodayRegisterActivity.this,MyDocListActivity.class);
				 intent.putExtra("DeptName", adapter.getItem(position));
			 }else{
				 return;
			 }
			 TodayRegisterActivity.this.startActivity(intent);
		}
	}

	/**
	 * 跳转科室列表页面
	 */
	class SelDepClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent in = new Intent(TodayRegisterActivity.this,
					DeptListActivity.class);
			TodayRegisterActivity.this.startActivity(in);
		}
	}

	class MyDocClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent in = new Intent(TodayRegisterActivity.this,
					MyDocListActivity.class);
			TodayRegisterActivity.this.startActivity(in);
		}
	}

	class OnReturn implements OnClickListener {
		@Override
		public void onClick(View v) {
			TodayRegisterActivity.this.onBackPressed();
		}
	}
}

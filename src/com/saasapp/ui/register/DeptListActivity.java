package com.saasapp.ui.register;

import java.util.List;

import com.saasapp.adapter.RegDeptListAdapter;
import com.saasapp.common.SimulatedData;
import com.saasapp.pojo.Department;
import com.saasapp.tools.RefreshableView;
import com.saasapp.tools.RefreshableView.PullToRefreshListener;
import com.saasapp.ui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class DeptListActivity extends Activity{
	private Button onReturn;
	private ListView deptListView;
	private List<Department> list=null;
	private RefreshableView refreshableView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置标题不可见
		setContentView(R.layout.reg_deptlist);
		deptListView=(ListView) findViewById(R.id.reg_deptlist);
		onReturn = (Button) findViewById(R.id.reg_deptlist_return);
		onReturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DeptListActivity.this.onBackPressed();
			}
		});
		refreshableView=(RefreshableView) findViewById(R.id.reg_deptlist_refreshable);
		refreshableView.setOnRefreshListener(new PullToRefreshListener(){
			@Override
			public void onRefresh() {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						refreshableView.finishRefreshing();
					}
				}).start();
			}},111);
		
		BindData();
	}
	
	private void BindData(){
		list = new SimulatedData().GetDeptList();
		RegDeptListAdapter regDeptAdapter = new RegDeptListAdapter(this, list);
		deptListView.setAdapter(regDeptAdapter);
		regDeptAdapter.notifyDataSetChanged();
	}
}

package com.saasapp.ui.register;

import java.util.List;
import java.util.Map;

import com.saasapp.adapter.RegMyDocListAdapter;
import com.saasapp.common.SimulatedData;
import com.saasapp.tools.RefreshableView;
import com.saasapp.tools.RefreshableView.PullToRefreshListener;
import com.saasapp.ui.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyDocListActivity extends Activity {

	private Button onReturn;
	private ListView mydoclist;
	private List<Map<String, Object>> list = null;
	private RefreshableView refreshableView;

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置标题不可见
		setContentView(R.layout.reg_mydoc);
		intent = this.getIntent();
		// Toast.makeText(this, "科室:"+in.getStringExtra("DeptName"),
		// Toast.LENGTH_LONG).show();
		InitView();
		BindData();
	}

	private void InitView() {
		onReturn = (Button) findViewById(R.id.reg_mydoc_return);
		mydoclist = (ListView) findViewById(R.id.reg_mydoclist);
		refreshableView = (RefreshableView) findViewById(R.id.reg_mydoc_refreshable);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 112);
		onReturn.setOnClickListener(new OnReturn());
	}

	private void BindData() {
		list = new SimulatedData().GetMyDocData();
		RegMyDocListAdapter rmdla = new RegMyDocListAdapter(this, list,
				mydoclist, intent);
		mydoclist.setAdapter(rmdla);
		rmdla.notifyDataSetChanged();
	}

	/**
	 * 返回
	 * 
	 * @author Administrator
	 */
	class OnReturn implements OnClickListener {
		@Override
		public void onClick(View v) {
			MyDocListActivity.this.onBackPressed();
		}
	}
}

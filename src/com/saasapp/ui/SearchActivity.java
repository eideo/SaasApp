package com.saasapp.ui;

import java.util.List;
import java.util.Map;

import com.saasapp.adapter.SearchNoticeListAdapter;
import com.saasapp.common.SimulatedData;
import com.saasapp.tools.RefreshableView;
import com.saasapp.tools.RefreshableView.PullToRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

public class SearchActivity extends Activity implements android.widget.RadioGroup.OnCheckedChangeListener {

	private List<Map<String, Object>> list = null;
	private ListView listNotice;
	private RadioGroup radioder;
	private Button searchReturn;
//	private RefreshableView searchRefreshable;			//下拉刷新
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_search);
		listNotice = (ListView) findViewById(R.id.search_noticelist);
		radioder = (RadioGroup) findViewById(R.id.search_radio);
		searchReturn = (Button) findViewById(R.id.search_return);
		searchReturn.setOnClickListener(new OnReturn());
//		searchRefreshable=(RefreshableView) findViewById(R.id.search_refreshable);
//		searchRefreshable.setOnRefreshListener(new PullToRefreshListener() {
//			@Override
//			public void onRefresh() {
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						searchRefreshable.finishRefreshing();
//					}
//				}).start();
//			}
//		}, 2);
		radioder.setOnCheckedChangeListener(this);
		radioder.check(R.id.search_notice);
		
		BindData(radioder.getCheckedRadioButtonId());
	}

	/**
	 * 绑定页面信息
	 */
	private void BindData(int checkedId) {

		switch (checkedId) {
		case R.id.search_notice:
			list = new SimulatedData().GetSearchNoticeData();
			break;
		case R.id.search_individual:
			list = new SimulatedData().GetSearchIndividualData();
			break;
		}
		SearchNoticeListAdapter snla = new SearchNoticeListAdapter(this, list);
		listNotice.setAdapter(snla);
		snla.notifyDataSetChanged();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		listNotice.setAdapter(null);
		BindData(checkedId);
	}

	class OnReturn implements OnClickListener {
		@Override
		public void onClick(View v) {
//			Intent in = new Intent(SearchActivity.this, IndexActivity.class);
//			SearchActivity.this.startActivity(in);
			FrameActivity.PageChange(R.id.mainTabs_radio_home);
		}
	}
}

package com.saasapp.ui.register;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.saasapp.adapter.RegDataTimeAdapter;
import com.saasapp.common.SimulatedData;
import com.saasapp.ui.R;

public class RegTimeActivity extends Activity {

	private TextView regDate;
	private ListView regTimeListView;
	private Button regCancel;
	private Intent in = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
		setContentView(R.layout.reg_regtime);
		regDate = (TextView) findViewById(R.id.reg_regtime_date);
		regTimeListView = (ListView) findViewById(R.id.reg_regtimelist);
		regCancel = (Button) findViewById(R.id.reg_regtime_cancel);
		regCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RegTimeActivity.this.onBackPressed();
			}
		});
		in = this.getIntent();
		// Toast.makeText(this, "医生名:"+in.getStringExtra("DocName"),
		// Toast.LENGTH_LONG).show();
		BindData();
	}

	private void BindData() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
																	// HH:mm:ss
		regDate.setText("挂号时间选择    " + df.format(new Date()));
		regDate.setTextSize(18);
		in.putExtra("RegDate", df.format(new Date()).toString());
		List<Map<String, Object>> list = new SimulatedData().GetRegTimeList();
		RegDataTimeAdapter rdta = new RegDataTimeAdapter(this, list, in);
		regTimeListView.setAdapter(rdta);
		rdta.notifyDataSetChanged();
	}
}

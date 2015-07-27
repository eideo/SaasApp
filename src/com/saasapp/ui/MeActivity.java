package com.saasapp.ui;

import com.saasapp.common.SharedConfig;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MeActivity extends Activity {

	private TextView account;
	private TextView info;
	private TextView hospital;
	private SharedPreferences shared;
	private Button meReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_me);
		account = (TextView) findViewById(R.id.myself_accounts);
		info = (TextView) findViewById(R.id.myself_info);
		hospital = (TextView) findViewById(R.id.myself_hospital);
		meReturn = (Button) findViewById(R.id.myself_return);
		meReturn.setOnClickListener(new OnReturn());
		shared = new SharedConfig(this).GetConfig();
		// 测试<u>下划线</u>、<i>斜体字</i>、<font color='red'>红色字</font>的格式"
		// Html.fromHtml("<font color='bule'>"+"123456"+"</font>")
		account.setText(Html.fromHtml(getResources().getString(
				R.string.myself_accounts)
				+ "<font color='#009BD3'>" + "123456" + "</font>"));
		info.setText(Html.fromHtml(getResources().getString(
				R.string.myself_info)
				+ "<font color='#009BD3'>" + "张三" + "</font>"));
		hospital.setText(Html.fromHtml(getResources().getString(
				R.string.myself_hospital)
				+ "<font color='#009BD3'>"
				+ shared.getString("HospitalName", "请选择就诊医院") + "</font>"));
	}

	class OnReturn implements OnClickListener {
		@Override
		public void onClick(View v) {
//			Intent in =new Intent(MeActivity.this,IndexActivity.class);
//			MeActivity.this.startActivity(in);
			FrameActivity.PageChange(R.id.mainTabs_radio_home);
		}
	}
}

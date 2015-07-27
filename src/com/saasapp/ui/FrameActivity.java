package com.saasapp.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

import com.saasapp.common.Constant;
import com.saasapp.tools.BadgeView;

@SuppressWarnings("deprecation")
public class FrameActivity extends TabActivity implements OnCheckedChangeListener {

	private static TabHost tabHost;
	private static RadioGroup radioderGroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置标题不可见
		setContentView(R.layout.ui_frame);
		tabHost = this.getTabHost();
		tabHost.addTab(tabHost.newTabSpec("1").setIndicator("1").setContent(new Intent(this, IndexActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("2").setIndicator("2").setContent(new Intent(this, SearchActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("3").setIndicator("3").setContent(new Intent(this, MeActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("4").setIndicator("4").setContent(new Intent(this, HelpActivity.class)));
		radioderGroup = (RadioGroup) findViewById(R.id.main_radio);
		radioderGroup.setOnCheckedChangeListener(this);
		radioderGroup.check(R.id.mainTabs_radio_home);// 默认第一个按钮
		
	}

	public static void PageChange(int checkedId)
	{
		switch (checkedId) {
		case R.id.mainTabs_radio_home:
			radioderGroup.check(R.id.mainTabs_radio_home);
			tabHost.setCurrentTabByTag("1");
			break;
		case R.id.mainTabs_radio_search:
			tabHost.setCurrentTabByTag("2");
			break;
		case R.id.mainTabs_radio_selfInfo:
			tabHost.setCurrentTabByTag("3");
			break;
		case R.id.mainTabs_radio_help:
			tabHost.setCurrentTabByTag("4");
			break;
		}
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		PageChange(checkedId);
	}

	/**
	 * 按两次返回退出程序
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() != KeyEvent.ACTION_UP) {
			if ((System.currentTimeMillis() - Constant.LAST_TIME) > Constant.INTERVAL_TIME) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
				Constant.LAST_TIME = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
}

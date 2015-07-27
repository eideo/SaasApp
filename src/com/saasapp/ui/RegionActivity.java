package com.saasapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.saasapp.common.SharedConfig;
import com.saasapp.common.SimulatedData;
import com.saasapp.pojo.Hospital;
import com.saasapp.pojo.RegionOfAddress;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class RegionActivity extends Activity implements OnClickListener {

	private TextView hosname;
	private TableLayout regionBtn;
	private LinearLayout hospitalBtn;
	private Button confirm;
	private Button regReturn;
	private final int rows = 4;
	private List<RegionOfAddress> list;
	private static int regionId;
	private Drawable leftDraw=null;
	private Drawable rightDraw=null;
	private Drawable rightDraw_s=null;
	private SharedPreferences shared;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置标题不可见
		setContentView(R.layout.index_region);
		InitView();
		BindRegionBtn();
		String name = shared.getString("HospitalName", "请选择就诊医院");
		hosname.setText(name);
	}

	/**
	 * 初始化UI控件
	 */
	private void InitView() {
		hosname = (TextView) findViewById(R.id.region_hosname);
		shared = new SharedConfig(this).GetConfig();
		confirm = (Button) findViewById(R.id.region_confirm);
		regReturn=(Button) findViewById(R.id.region_return);
		regionBtn = (TableLayout) findViewById(R.id.region_buttons);
		hospitalBtn = (LinearLayout) findViewById(R.id.hospital_buttons);
		confirm.setOnClickListener(new OnConfirm());
		regReturn.setOnClickListener(new OnConfirm());
	}

	/**
	 * 绑定地区信息
	 */
	private void BindRegionBtn() {
		list = new SimulatedData().GetRegionData();
		if (list.size() == 0) {
			return;
		}
		TableRow.LayoutParams trparams = new TableRow.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		trparams.weight = 1;
		// trparams.gravity = 17; // 17是控件居中
		trparams.leftMargin = 5;
		trparams.rightMargin = 5;
		trparams.topMargin = 5;
		trparams.bottomMargin = 5;
		TableLayout.LayoutParams tabparams = new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		int countPage = list.size() / rows + 1;
		int supplement = rows - (list.size() % rows);
		for (int r = 0; r < countPage; r++) {
			TableRow tr = new TableRow(this);
			for (int d = 0; d < rows; d++) {
				if ((r * rows + d) == list.size()) {
					for (int s = 0; s < supplement; s++) {
						TextView tv = new TextView(this);
						tr.addView(tv, trparams);
					}
					break;
				}
				Button button = new Button(this);
				button.setId(1000 + (r * rows + d));
				button.setTextSize(15);
				button.setOnClickListener(this);
				button.setText(list.get(r * rows + d).getRegionName());
				button.setBackgroundResource(R.drawable.my_white_gray2);
				// button.setBackgroundColor(Color.BLUE); //设置背景颜色
				tr.addView(button, trparams);
			}
			regionBtn.addView(tr, tabparams);
		}
		// BindHospital(list.get(0).getList());
	}

	/**
	 * 绑定医院
	 */
	@SuppressWarnings("deprecation")
	private void BindHospital(List<Hospital> hslist) {
		String name = hosname.getText().toString();

		leftDraw = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.logopic));
		leftDraw.setBounds(0, 0, 64, 64);
		rightDraw = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.round));
		rightDraw.setBounds(0, 0, 64, 64);
		rightDraw_s = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.round_s));
		rightDraw_s.setBounds(0, 0, 64, 64);
		for (int i = 0; i < hslist.size(); i++) {
			Button btn = new Button(this);
			btn.setOnClickListener(this);
			btn.setId(2000 + i);
			btn.setTextSize(15);
			btn.setText(hslist.get(i).getHospitalName());
			btn.setBackgroundResource(R.drawable.my_white_gray2);

			if (hslist.get(i).getHospitalName().equals(name)) {
				btn.setCompoundDrawables(leftDraw, null, rightDraw, null);
			} else {
				btn.setCompoundDrawables(leftDraw, null, rightDraw_s, null);
			}
			hospitalBtn.addView(btn);
		}
	}

	@Override
	public void onClick(View v) {
		int vv = v.getId();
		 Log.d("TAG", "vv:" + vv);
		if (vv < 2000) {
			for (int i = 0; i < list.size(); i++) {
				if ((vv - 1000) == i) {
					regionId = i;
					v.setBackgroundColor(Color.BLUE);
					hospitalBtn.removeAllViews();
					BindHospital(list.get(i).getList());
				} else {
					Log.d("TAG", "id:" + (1000 + i));
					this.findViewById(1000 + i).setBackgroundResource(
							R.drawable.my_white_gray2);
				}
			}
		} else {
			for (int j = 0; j < list.get(regionId).getList().size(); j++) {
				if ((vv - 2000) == j) {
					v.setBackgroundColor(Color.BLUE);	//#11C1F3
					hosname.setText(list.get(regionId).getList().get(j)
							.getHospitalName());
					((Button) v).setCompoundDrawables(leftDraw, null, rightDraw_s, null);
				} else {
					this.findViewById(2000 + j).setBackgroundResource(
							R.drawable.my_white_gray2);
				}
			}
		}
	}
	
	public void GoBack(){
		String name = hosname.getText().toString();
		if (name !=null && name != "") {
			SharedPreferences shared = new SharedConfig(RegionActivity.this).GetConfig();
			Editor editor = shared.edit();
			editor.putString("HospitalName", name);
			editor.commit();
			Intent in = new Intent(RegionActivity.this, FrameActivity.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 		//彻底清除当前activity
			RegionActivity.this.startActivity(in);
		}
	}
	
	class OnConfirm implements OnClickListener {
		@Override
		public void onClick(View v) {
			GoBack();
		}
	}
	
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event)  
    {  
        if (keyCode == KeyEvent.KEYCODE_BACK )  
        {  
        	GoBack();
//            // 创建退出对话框  
//            AlertDialog isExit = new AlertDialog.Builder(this).create();  
//            // 设置对话框标题  
//            isExit.setTitle("系统提示");  
//            // 设置对话框消息  
//            isExit.setMessage("确定要退出吗");  
//            // 添加选择按钮并注册监听  
////            isExit.setButton("确定", listener);  
////            isExit.setButton2("取消", listener);  
//            // 显示对话框  
//            isExit.show();  
        }  
        return false;  
    } 
}

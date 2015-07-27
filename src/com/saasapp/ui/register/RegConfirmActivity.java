package com.saasapp.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.saasapp.common.Methods;
import com.saasapp.tools.BadgeView;
import com.saasapp.ui.R;

public class RegConfirmActivity extends Activity {

	private TextView comfirmTitle;
	private Button comfirmReturn;

	private ImageView docPic;
	private TextView docName;
	private TextView docTitle;
	private TextView docIntroduction;

	private TextView deptName;
	private TextView regAmt;
	private TextView visitTime;

	private TextView currentAccount;
	private Button changePat;
	
	private Button confirm;
	
	private Intent in = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.reg_regconfirm);
		InitView();
	}

	private void InitView() {
		in = this.getIntent();
		// 标题
		comfirmTitle = (TextView) findViewById(R.id.reg_regconfirm_title);
		comfirmTitle.setText(in.getStringExtra("DeptName") + "-"
				+ in.getStringExtra("DocName"));
		Log.d("TAG",
				in.getStringExtra("DeptName") + "-"
						+ in.getStringExtra("DocName"));
		comfirmReturn = (Button) findViewById(R.id.reg_regconfirm_return);
		comfirmReturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RegConfirmActivity.this.onBackPressed();
			}
		});
		// 医生信息
		int picId = 0;String introstr="";
		if (!in.getStringExtra("DocPic").isEmpty()) {
			picId = Integer.parseInt(in.getStringExtra("DocPic").toString());
		} else {
			picId = R.drawable.no_doc;
		}
		if (!in.getStringExtra("DocIntroduction").isEmpty()) {
			introstr = in.getStringExtra("DocIntroduction").toString();
		} else {
			introstr = "暂无介绍";
		}

		docPic = (ImageView) findViewById(R.id.reg_regconfirm_pic);
		docPic.setImageDrawable(Methods.matrixImg(this, picId, 360, 480));
		docName = (TextView) findViewById(R.id.reg_regconfirm_name);
		docName.setText(in.getStringExtra("DocName"));
		docTitle = (TextView) findViewById(R.id.reg_regconfirm_doctitle);
		docTitle.setText(in.getStringExtra("DocTitle"));
		docIntroduction = (TextView) findViewById(R.id.reg_regconfirm__introduction);
		docIntroduction.setText(introstr);
		deptName = (TextView) findViewById(R.id.reg_regconfirm_deptname);
		deptName.setText(in.getStringExtra("DeptName"));
		regAmt = (TextView) findViewById(R.id.reg_regconfirm_regamt);
		regAmt.setText(Html.fromHtml("<font color='#009BD3'>" + "7"
				+ "</font> 元"));
		visitTime = (TextView) findViewById(R.id.reg_regconfirm_visittime);
		visitTime.setText(in.getStringExtra("RegDate") + "  "
				+ in.getStringExtra("RegTime"));

		currentAccount = (TextView) findViewById(R.id.reg_regconfirm_currentaccount);
		changePat = (Button) findViewById(R.id.reg_regconfirm_changepat);
		
		confirm=(Button) findViewById(R.id.reg_regconfirm_confirm);
		confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				Intent intent = new Intent();
			}
		});
	}
}

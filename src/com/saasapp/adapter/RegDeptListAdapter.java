package com.saasapp.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.saasapp.pojo.Department;
import com.saasapp.ui.R;
import com.saasapp.ui.register.MyDocListActivity;

public class RegDeptListAdapter extends BaseAdapter {

	private LayoutInflater layoutInflater;
	private List<Department> lm = new ArrayList<Department>();
	private Context context;

	public RegDeptListAdapter(Context con, List<Department> list) {
		this.context = con;
		this.lm = list;
		layoutInflater = LayoutInflater.from(con);
	}

	@Override
	public int getCount() {
		return lm.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		if (lm.get(position).getParentCode().equals("0")) {
			return position;
		}
		Intent in = new Intent(context, MyDocListActivity.class);
		in.putExtra("DeptName", lm.get(position).getDeptName());
		context.startActivity(in);
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView deptNameView = null;
		if (convertView == null) {
			convertView = layoutInflater
					.inflate(R.layout.common_textlist, null);
			deptNameView = (TextView) convertView.findViewById(R.id.common_onetext);
			convertView.setTag(deptNameView);
		} else {
			deptNameView = (TextView) convertView.getTag();
		}
		String name = lm.get(position).getDeptName();
		String code = lm.get(position).getParentCode();
		if (code.equals("0")) {
			deptNameView.setText(Html.fromHtml("<font color='#009BD3'>" + name
					+ "</font>"));
			deptNameView.setClickable(false);
		} else {
			Drawable drwa=context.getResources().getDrawable(R.drawable.arrow_right);
			deptNameView.setText(name);
			deptNameView.setCompoundDrawables(null, null, null, drwa);
		}
		return convertView;
	}
}

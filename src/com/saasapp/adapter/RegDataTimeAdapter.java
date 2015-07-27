package com.saasapp.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.saasapp.ui.R;
import com.saasapp.ui.register.RegConfirmActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class RegDataTimeAdapter extends BaseAdapter {

	private List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
	private Context context;
	private LayoutInflater layoutInflater;
	private Intent intent = null;

	public RegDataTimeAdapter(Context con, List<Map<String, Object>> list,
			Intent in) {
		this.context = con;
		this.lm = list;
		this.intent = in;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return lm.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
//		Log.d("TAG", "RegDataTimeAdapter:"+position+"__"+context.getClass());
		Intent in = new Intent(context, RegConfirmActivity.class);
		in.putExtra("DeptName", intent.getStringExtra("DeptName"));
		in.putExtra("RegDate", intent.getStringExtra("RegDate"));
		in.putExtra("RegTime", lm.get(position).get("Time").toString());
		in.putExtra("DocPic", intent.getStringExtra("DocPic"));
		in.putExtra("DocName", intent.getStringExtra("DocName"));
		in.putExtra("DocTitle", intent.getStringExtra("DocTitle"));
		in.putExtra("DocIntroduction", intent.getStringExtra("DocIntroduction"));
		((Activity)context).finish();
		context.startActivity(in);
		// Toast.makeText(context, "挂号时间:"+lm.get(position).get("Time"),
		// Toast.LENGTH_LONG).show();
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ListItemView listItemView = null;
		if (convertView == null) {
			listItemView = new ListItemView();
			convertView = layoutInflater.inflate(R.layout.reg_regtime_item,
					null);
			listItemView.period = (TextView) convertView
					.findViewById(R.id.reg_regtime_period);
			listItemView.time = (TextView) convertView
					.findViewById(R.id.reg_regtime_time);
			listItemView.surplus = (TextView) convertView
					.findViewById(R.id.reg_regtime_surplus);
			convertView.setTag(listItemView);
		} else {
			listItemView = (ListItemView) convertView.getTag();
		}
		listItemView.period.setText((String) lm.get(position).get("Period"));
		listItemView.time.setText((String) lm.get(position).get("Time"));
		listItemView.surplus.setText("剩余"
				+ (String) lm.get(position).get("Surplus") + "个");

		return convertView;
	}

	final class ListItemView {
		public TextView period;
		public TextView time;
		public TextView surplus;
	}
}

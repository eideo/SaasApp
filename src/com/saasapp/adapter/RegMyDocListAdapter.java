package com.saasapp.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.saasapp.common.Methods;
import com.saasapp.ui.R;
import com.saasapp.ui.register.RegTimeActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RegMyDocListAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater layoutInflater;
	private List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
	private ListView listView;
	private Intent intent = null;

	public RegMyDocListAdapter(Context con, List<Map<String, Object>> lm,
			ListView lv, Intent in) {
		this.context = con;
		this.listData = lm;
		this.listView = lv;
		this.intent = in;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ListItemView listItemView = null;
		if (convertView == null) {
			listItemView = new ListItemView();
			// 获取list_item布局文件的视图
			convertView = layoutInflater.inflate(R.layout.reg_mydoc_listitem,
					null);
			// 获取控件对象
			listItemView.pic = (ImageView) convertView
					.findViewById(R.id.reg_mydoc_pic);
			listItemView.name = (TextView) convertView
					.findViewById(R.id.reg_mydoc_name);
			listItemView.title = (TextView) convertView
					.findViewById(R.id.reg_mydoc_title);
			listItemView.introduction = (TextView) convertView
					.findViewById(R.id.reg_mydoc_introduction);
			listItemView.todayreg = (Button) convertView
					.findViewById(R.id.reg_mydoc_todayreg);
			listItemView.bookreg = (Button) convertView
					.findViewById(R.id.reg_mydoc_bookreg);
			listItemView.btnDetel = (Button) convertView
					.findViewById(R.id.reg_mydoc_detel);
			// 设置控件集到convertView
			convertView.setTag(listItemView);
		} else {
			listItemView = (ListItemView) convertView.getTag();
		}
		int picId = 0;
		String introstr = "";
		// 设置文字和图片
		if (!((String) listData.get(position).get("Pic")).isEmpty()) {
			picId = Integer
					.parseInt((String) listData.get(position).get("Pic"));
		} else {
			picId = R.drawable.no_doc;
		}
		if (!((String) listData.get(position).get("Introduction")).isEmpty()) {
			introstr = (String) listData.get(position).get("Introduction");
		} else {
			introstr = "暂无介绍";
		}
		listItemView.pic.setImageDrawable(Methods.matrixImg(context, picId,
				260, 350));
		listItemView.name.setText((String) listData.get(position).get("Name"));
		listItemView.title
				.setText((String) listData.get(position).get("Title"));
		listItemView.introduction.setText(introstr);
		listItemView.btnDetel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DetelListItem(position);
			}
		});
		listItemView.todayreg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				GoRegTime(position);
			}
		});
		return convertView;
	}

	private void GoRegTime(int position) {
		Intent in = new Intent(context, RegTimeActivity.class);
		in.putExtra("DeptName", intent.getStringExtra("DeptName"));
		in.putExtra("DocPic", (String) listData.get(position).get("Pic"));
		in.putExtra("DocName", (String) listData.get(position).get("Name"));
		in.putExtra("DocTitle", (String) listData.get(position).get("Title"));
		in.putExtra("DocIntroduction",
				(String) listData.get(position).get("Introduction"));
		context.startActivity(in);
	}

	/**
	 * 删除选择listView的item
	 */
	private void DetelListItem(int position) {
		listData.remove(position);
		listView.setAdapter(this);
		this.notifyDataSetChanged();
		listView.setSelection(position);
	}

	public final class ListItemView { // 自定义控件集合
		public ImageView pic;
		public TextView name;
		public TextView title;
		public TextView introduction;
		public Button todayreg;
		public Button bookreg;
		public Button btnDetel;
	}
}

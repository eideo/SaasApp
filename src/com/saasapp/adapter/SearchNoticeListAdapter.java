package com.saasapp.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.saasapp.ui.R;

public class SearchNoticeListAdapter extends BaseAdapter {

	private LayoutInflater listContainer; // 视图容器

	private Context context;
	private List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

	public SearchNoticeListAdapter(Context con, List<Map<String,Object>> lm) {
		this.context = con;
		this.list = lm;
		listContainer = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 自定义视图
		ListItemView listItemView = null;
		if (convertView == null) {
			listItemView = new ListItemView();
			// 获取list_item布局文件的视图
			convertView = listContainer.inflate(
					R.layout.search_notice_listitem, null);
			// 获取控件对象
			listItemView.searchTitle = (TextView) convertView
					.findViewById(R.id.search_title);
			listItemView.searchContext = (TextView) convertView
					.findViewById(R.id.search_context);
			listItemView.searchTime = (TextView) convertView
					.findViewById(R.id.search_time);
			// 设置控件集到convertView
			convertView.setTag(listItemView);
		} else {
			listItemView = (ListItemView) convertView.getTag();
		}

		// 设置文字和图片
		listItemView.searchTitle.setText((String) list.get(position).get("title")
				);
		listItemView.searchContext.setText((String) list.get(position)
				.get("context"));
		listItemView.searchTime.setText((String) list.get(position)
				.get("time"));
		
		return convertView;
	}

	public final class ListItemView { // 自定义控件集合
		public TextView searchTitle;
		public TextView searchContext;
		public TextView searchTime;
	}
}

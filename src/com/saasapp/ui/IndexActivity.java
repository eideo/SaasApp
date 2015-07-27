package com.saasapp.ui;

import java.util.ArrayList;
import java.util.List;

import com.saasapp.adapter.CycleViewPager;
import com.saasapp.common.ImgTextBtn;
import com.saasapp.common.Methods;
import com.saasapp.common.SharedConfig;
import com.saasapp.ui.register.TodayRegisterActivity;
import com.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IndexActivity extends Activity {

	private SlidingMenu menu; // 侧滑控件
	private TextView removeconfig;
	private TextView hosname;

	private List<Drawable> drawables = new ArrayList<Drawable>();
	private CycleViewPager pager;
	private ImageViewAdapter adapter;

	private Button changehospital;

	private LinearLayout regFunLayout = null;
	private SharedPreferences shared;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_index);
		InitView();
		GetImageData();
		BindRegFun();
		BindFunMenu();
		SetSlidingMenu();
		String name = shared.getString("HospitalName", "请选择就诊医院");
		hosname.setText(name);
	}

	class ImageViewAdapter extends PagerAdapter {
		private int count = 6;

		public ImageViewAdapter(int ImgCount) {
			this.count = ImgCount;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {
			return count;
		}

		public Object instantiateItem(android.view.ViewGroup container,
				int position) {
			ImageView item = new ImageView(IndexActivity.this);
			// item.setImageDrawable(drawables.get(position));
			item.setBackgroundDrawable(drawables.get(position));
			container.addView(item);
			return item;
		}

		public void destroyItem(android.view.ViewGroup container, int position,
				Object object) {
			container.removeView((View) object);
		}
	};

	/**
	 * 初始化UI控件
	 */
	public void InitView() {
		shared = new SharedConfig(this).GetConfig();
		pager = (CycleViewPager) findViewById(R.id.pager); // 主题图片
		regFunLayout = (LinearLayout) findViewById(R.id.regfun); // 挂号功能模块
		hosname = (TextView) findViewById(R.id.index_hosname);
		menu = new SlidingMenu(this);
		changehospital = (Button) findViewById(R.id.changehospital);
		changehospital.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(IndexActivity.this, RegionActivity.class);
				IndexActivity.this.startActivity(in);
				IndexActivity.this.getParent().startActivityForResult(in, 0);
				IndexActivity.this.getParent().overridePendingTransition(
						R.anim.slide_up_in, R.anim.slide_down_out);
			}
		});
	}

	/**
	 * 设置侧滑控件
	 */
	public void SetSlidingMenu() {
		// menu.setMode(SlidingMenu.LEFT); //侧滑模式（左，右，左右同时打开）
		// 设置是全屏拉动出发(TOUCHMODE_FULLSCREEN)，还是在某一视图中启用(TOUCHMODE_MARGIN)屏幕边缘，(TOUCHMODE_NONE)滑动不触发
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影宽度
		// 设置菜单占屏幕的比例 设置menu占屏幕的 2/3
		// menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth() / 3);
		menu.setFadeDegree(0.85f);// 滑动过程中的渐变程度
		menu.setFadeEnabled(true);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		View view = LayoutInflater.from(this).inflate(R.layout.index_menu_item,
				null);
		removeconfig = (TextView) view.findViewById(R.id.removeconfig);
		menu.setMenu(view);

		removeconfig.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(IndexActivity.this, "清除引导完成", Toast.LENGTH_LONG)
						.show();
				new SharedConfig(IndexActivity.this).ClearConfig();
			}
		});
	}

	/**
	 * 获得医院主题图片
	 */
	public void GetImageData() {

		int[] aa = new int[] { R.drawable.guide_04, R.drawable.guide_05,
				R.drawable.guide_01, R.drawable.guide_02, R.drawable.guide_03 };
		for (int i = 0; i < aa.length; i++) {
			Drawable draw = getResources().getDrawable(aa[i]);
			drawables.add(draw);
		}

		adapter = new ImageViewAdapter(drawables.size());
		pager.context = IndexActivity.this;
		pager.indicatorLayout = (LinearLayout) findViewById(R.id.CycleIndicator);
		pager.setAdapter(adapter);
	}

	/**
	 * 设置挂号功能按钮
	 */
	public void BindRegFun() {
		ImgTextBtn regToday = new ImgTextBtn(this, R.drawable.index_reg_today,
				R.string.index_reg_today, ImgTextBtn.TOP, true);
		ImgTextBtn regBook = new ImgTextBtn(this, R.drawable.index_reg_book,
				R.string.index_reg_book, ImgTextBtn.TOP, true);
		ImgTextBtn regRem = new ImgTextBtn(this, R.drawable.index_reg_rem,
				R.string.index_reg_rem, ImgTextBtn.TOP, true);
		ImgTextBtn regSmart = new ImgTextBtn(this, R.drawable.index_reg_smart,
				R.string.index_reg_smart, ImgTextBtn.TOP, true);
		regFunLayout.addView(regToday);
		regFunLayout.addView(regBook);
		regFunLayout.addView(regRem);
		regFunLayout.addView(regSmart);
		regToday.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(IndexActivity.this,
						TodayRegisterActivity.class);
				IndexActivity.this.startActivity(in);
			}
		});
		regBook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		regRem.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		regSmart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	/**
	 * 绑定功能菜单
	 */
	public void BindFunMenu() {

		Button mzjf = (Button) findViewById(R.id.mzjf);
		Button zyyj = (Button) findViewById(R.id.zyyj);
		Button sbyy = (Button) findViewById(R.id.sbyy);
		Button hzrs = (Button) findViewById(R.id.hzrs);
		Button yyjs = (Button) findViewById(R.id.yyjs);
		Button ksfb = (Button) findViewById(R.id.ksfb);
		Button ylzx = (Button) findViewById(R.id.ylzx);
		Button hdjl = (Button) findViewById(R.id.hdjl);
		Button ypyj = (Button) findViewById(R.id.ypyj);

		Drawable mzjfDrawable = Methods.matrixImg(this, R.drawable.index_mzjf,
				100, 100);
		mzjf.setCompoundDrawables(mzjfDrawable, null, null, null);

		Drawable zyyjDrawable = Methods.matrixImg(this, R.drawable.index_zyyj,
				100, 100);
		zyyj.setCompoundDrawables(null, null, zyyjDrawable, null);

		Drawable sbyyDrawable = Methods.matrixImg(this, R.drawable.index_sbyy,
				100, 100);
		sbyy.setCompoundDrawables(sbyyDrawable, null, null, null);

		Drawable hzrsDrawable = Methods.matrixImg(this, R.drawable.index_hzrs,
				100, 100);
		hzrs.setCompoundDrawables(null, null, hzrsDrawable, null);

		Drawable yyjsDrawable = Methods.matrixImg(this, R.drawable.index_yyjs,
				100, 100);
		yyjs.setCompoundDrawables(yyjsDrawable, null, null, null);

		Drawable ksfbDrawable = Methods.matrixImg(this, R.drawable.index_ksfb,
				100, 100);
		ksfb.setCompoundDrawables(null, null, ksfbDrawable, null);

		Drawable ylzxDrawable = Methods.matrixImg(this, R.drawable.index_ylzx,
				100, 100);
		ylzx.setCompoundDrawables(ylzxDrawable, null, null, null);

		Drawable hdjlDrawable = Methods.matrixImg(this, R.drawable.index_hdjl,
				100, 100);
		hdjl.setCompoundDrawables(null, null, hdjlDrawable, null);

		Drawable ypyjDrawable = Methods.matrixImg(this, R.drawable.index_ypyj,
				100, 100);
		ypyj.setCompoundDrawables(ypyjDrawable, null, null, null);

		mzjf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		zyyj.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		sbyy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		hzrs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		yyjs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		ksfb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		ylzx.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		hdjl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		ypyj.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			menu.toggle();
		}
		return super.onKeyDown(keyCode, event);
	}
}

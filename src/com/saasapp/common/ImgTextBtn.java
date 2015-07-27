package com.saasapp.common;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saasapp.ui.R;

/**
 * 自定义图片文字按钮，指定图片对应位置
 * 
 * @author Guanwj
 */
public class ImgTextBtn extends LinearLayout {

	private ImageView myImage;
	private TextView myText;
	
	public static int TOP = 1;
	public static int BUTTON = 2;
	public static int LEFT = 3;
	public static int RIGHT = 4;
	
	public ImgTextBtn(Context context, int imageResId, int textResId,
			int ImgPosition,boolean event) 
	{
		super(context);
		// 获取样式属性
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.weight = 1.0f; // 平均分布
		params.gravity = 17; // 17是控件居中
		params.leftMargin = 10;
		params.rightMargin = 10;
		params.topMargin = 0;
		params.bottomMargin = 0;
		this.setLayoutParams(params);
		// 设置本布局的属性
		setClickable(event); // 可点击
		setFocusable(event); // 可聚焦
		myImage = new ImageView(context);
		myText = new TextView(context);
		myImage.setImageResource(imageResId);
		myText.setText(textResId);
		myImage.setPadding(5, 5, 5, 5);
		myText.setPadding(5, 5, 5, 5);
		myText.setTextColor(0xFF000000);
		setBackgroundResource(R.drawable.my_white_gray); // 布局才用普通按钮的背景
		myText.setGravity(Gravity.CENTER);
		if (ImgPosition == 1) {
			setOrientation(LinearLayout.VERTICAL); // 垂直布局
			addView(myImage);
			addView(myText);
		}else if(ImgPosition == 2){
			setOrientation(LinearLayout.VERTICAL); // 垂直布局
			addView(myText);
			addView(myImage);
		} else if (ImgPosition == 3) {
			setOrientation(LinearLayout.HORIZONTAL); // 水平布局
			addView(myImage);
			addView(myText);
		} else if (ImgPosition == 4) {
			setOrientation(LinearLayout.HORIZONTAL); // 水平布局
			addView(myText);
			addView(myImage);
		}
	}
}

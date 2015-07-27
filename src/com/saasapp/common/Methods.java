package com.saasapp.common;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class Methods {

	/**
	 * 改变图片为指定大小
	 */
	@SuppressWarnings("deprecation")
	public static Drawable matrixImg(Context context, int resId, int width,
			int height) {
		Bitmap bitMap = BitmapFactory.decodeResource(context.getResources(),
				resId);
		Matrix mMatrix = new Matrix();
		// 得到传进来的图片宽和高
		int bmWidth = bitMap.getWidth();
		int bmHight = bitMap.getHeight();
		// 计算缩放比例
		float scaleWidth = ((float) width) / bmWidth;
		float scaleHeight = ((float) height) / bmHight;
		mMatrix.postScale(scaleWidth, scaleHeight);
		Bitmap bitMapDisplay = Bitmap.createBitmap(bitMap, 0, 0, bmWidth, bmHight,
				mMatrix, true);
		Drawable drawable = new BitmapDrawable(bitMapDisplay);
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		return drawable;
	}

	/**
	 * 获取远程图片
	 * 
	 * @param url
	 * @return Bitmap
	 */
	public Bitmap GetRemoteImg(String url) {
		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream(new URL(url).openStream());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bitmap;
	}

	/**
	 * 获取多个远程图片
	 * 
	 * @param url数组
	 * @return List<Bitmap>
	 */
	public static List<Bitmap> GetRemoteListImg(String[] url) {
		List<Bitmap> list = new ArrayList<Bitmap>();
		try {
			for (int i = 0; i < url.length; i++) {
				Bitmap bitmap = BitmapFactory.decodeStream(new URL(url[i])
						.openStream());
				list.add(bitmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}

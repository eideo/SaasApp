package com.saasapp.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

//获得软件的全局配置文件
public class SharedConfig {
	Context context;
	SharedPreferences shared;
	public SharedConfig(Context context){
		this.context=context;
		shared=context.getSharedPreferences(Constant.SHARED_CONFIG, Context.MODE_PRIVATE);
	}

	public SharedPreferences GetConfig(){
		return shared;
	}
	public void ClearConfig(){
		shared.edit().clear().commit();
	}
	
	/**
	 * 存入
	 * SharedPreferences shared = new SharedConfig(this).GetConfig();
			Editor editor = shared.edit();
			editor.putBoolean("First", false);
			editor.commit();
			
		SharedPreferences shared = new SharedConfig(this).GetConfig(); // 得到配置文件
		first = shared.getBoolean("First", true);
	 */
}

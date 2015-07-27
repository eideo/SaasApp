package com.saasapp.common;

public class Constant {

	/** ——————服务器信息—————— ***********************************************************************/
	// 服务器地址
	public static final String SERVER_URL = "";
	// 科室路径
	public static final String DEPT_URL = SERVER_URL + "/Register/GetRegDept";
	// 一次加载多少条数据
	public static final int PAGE_SHOW = 20;
	
	

	/** ——————常用配置—————— ************************************************************************/
	// 手机返回按钮：保留上次点击返回键时间
	public static long LAST_TIME = 0;
	// 手机返回按钮：点击返回键间隔时间，如果在该时间内则退出程序.毫秒单位
	public static final long INTERVAL_TIME = 2000;
	// 文本储存：写入SharedPreferences保存文件名
	public static final String SHARED_CONFIG = "SharedConfig";
	// 进入程序动画：动画播放时间
	public static final int ANIMATION_TIME = 1000;
}

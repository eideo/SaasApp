package com.saasapp.ui;

import com.saasapp.common.AsyncImageLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HelpActivity extends Activity{
	
	private Button onReturn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_help);
		onReturn = (Button) findViewById(R.id.help_return);
		onReturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FrameActivity.PageChange(R.id.mainTabs_radio_home);
			}
		});
		
		
		final ImageView iv = (ImageView)findViewById(R.id.iv);  
        //网络图片地址  
        String imgUrl = "http://img.dapixie.com/uploads/allimg/120222/1-120222112321.jpg";  
//      "http://pic.58pic.com/58pic/12/97/42/67k58PIC8pa.jpg",
//		"http://img.dapixie.com/uploads/allimg/120222/1-120222112321.jpg",
//		"http://img2.3lian.com/2014/f5/101/d/6.jpg"
        //for test  
        AsyncImageLoader loader = new AsyncImageLoader(getApplicationContext());  
          
        //将图片缓存至外部文件中  
        loader.setCache2File(true); //false  
        //设置外部缓存文件夹  
        loader.setCachedDir(this.getCacheDir().getAbsolutePath());  
          
        //下载图片，第二个参数是否缓存至内存中  
        loader.downloadImage(imgUrl, true/*false*/, new AsyncImageLoader.ImageCallback() {  
            @Override  
            public void onImageLoaded(Bitmap bitmap, String imageUrl) {  
                if(bitmap != null){  
                    iv.setImageBitmap(bitmap);  
                }else{  
                    //下载失败，设置默认图片  
                }  
            }  
        });  
	}
}

package com.xinlan.xinlandownload;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;

/**
 *
 */
public class MainActivity extends Activity {
	private Button mDownloadBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    
    private void init(){
    	mDownloadBtn=(Button)findViewById(R.id.doDownBtn);
    }
}//end class

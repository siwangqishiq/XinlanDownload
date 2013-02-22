package com.xinlan.xinlandownload;


import com.xinlan.xinlandownload.components.DownFile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;

/**
 *
 */
public class MainActivity extends Activity {
	private Button mDownloadBtn;
	private EditText mText;
	private DownTask mTask;
	private ProgressBar mBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    
    private void init(){
    	mText = (EditText)findViewById(R.id.url_content);
    	mDownloadBtn=(Button)findViewById(R.id.doDownBtn);
    	mBar=(ProgressBar)findViewById(R.id.progressBar);
    	mDownloadBtn.setOnClickListener(new BtnClick());
    }
    
    private class BtnClick implements OnClickListener{
		@Override
		public void onClick(View v) {
			String url=mText.getText().toString().trim();
			if(mTask==null){
				mTask = new DownTask();
			}
			mTask.execute(url);
		}
    }//end BtnClick
    
    private class DownTask extends AsyncTask<String, Integer, Integer>{
		@Override
		protected Integer doInBackground(String... params) {
			DownFile task=new DownFile(params[0]);
			
			//task.doDownload();
//			for(int i=0;i<100;i++){
//				publishProgress(i);
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			return 0;
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onPostExecute(Integer result) {
			Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_LONG).show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			mBar.setProgress(values[0]);
		}
    }//end DownTask class
}//end class

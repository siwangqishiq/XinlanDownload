package com.xinlan.xinlandownload;

import com.xinlan.xinlandownload.components.DownFile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

/**
 *
 */
public class MainActivity extends Activity {
	private Button mDownloadBtn;
	private EditText mText;
	private DownTask mTask;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    
    private void init(){
    	mText = (EditText)findViewById(R.id.url_content);
    	mDownloadBtn=(Button)findViewById(R.id.doDownBtn);
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
			task.doDownload();
			return null;
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onPostExecute(Integer result) {
			
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}
    }//end DownTask class
}//end class

package com.xinlan.xinlandownload.components;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.os.Environment;

public class DownFile {
	public static final String FOLDER = "xldownload";
	
	private String downloadURL;
	private int downThreadNum = 3;
	private int filesize;
	private String filename;
	private int cur_size;
	
	public DownFile(String url) {
		this.downloadURL = url;
		filename=getFilenameFromUrl(url);
	}

	public void doDownload() {
		try {
			URL url = new URL(downloadURL);
			URLConnection con = url.openConnection();
			filesize = con.getContentLength();// 获取资源大小
			String path=getSDPath()+File.separator+FOLDER;
			initFolder(path);
			writeToDisc(path+File.separator+filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initFolder(String path){
		File file=new File(path);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private int writeToDisc(String filepath){
		File file=new File(filepath);
		if(file.exists()){
			return 0;
		}
		//TODO
		
		return 0;
	}
	
	public synchronized int updateProgress(){
		return (int)((cur_size/filesize)*100);
	}
	
	/**
	 * 获取SD卡目录
	 * @return
	 */
	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
		}
		return sdDir.toString();
	}
	
	public static String getFilenameFromUrl(String url){
		int start=url.lastIndexOf("/");
		if(start!=-1){
			return url.substring(start+1);
		}
		return url;
	}
	
	private class DownloadThread extends Thread{
		@Override
		public void run(){
			try {
				URL url=new URL(downloadURL);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}//end inner class
}// end class

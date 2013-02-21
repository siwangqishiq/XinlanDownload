package com.xinlan.xinlandownload.components;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownFile {
	private String downloadURL;
	private int downThreadNum = 3;
	private int filesize;
	
	public DownFile(String url) {
		this.downloadURL = url;
	}

	public void doDownload() {
		try {
			URL url = new URL(downloadURL);
			URLConnection con = url.openConnection();
			filesize  = con.getContentLength();//获取资源大小
			//System.out.println("size--->"+filesize);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// end class

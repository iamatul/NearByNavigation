package com.bcet.nearbynavigation;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpService{

	String responseData;
	String url;
	public HttpService(String url) {
		// TODO Auto-generated constructor stub
	this.url=url;
	}
	
	public String getResponse() {
		
		HttpClient client=new DefaultHttpClient();
		HttpResponse resp=null;
		HttpEntity entity=null;
		HttpPost post=new HttpPost(url);
		try {
			resp=client.execute(post);
		    entity=resp.getEntity();
		    responseData=EntityUtils.toString(entity);
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseData;
		
	}
}

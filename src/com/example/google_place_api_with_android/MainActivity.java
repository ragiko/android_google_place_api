package com.example.google_place_api_with_android;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * GOOGLE PLACE API　から　情報を取得するサンプル
 */
public class MainActivity extends Activity implements Runnable {

	private String KEY = "AIzaSyAkVgpcO6IWROb-9jwkoP3wpdJHppkTW9M";
	private String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&sensor=false&key="
			+ KEY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Thread thread = new Thread(this);
		thread.start();

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// google place　から情報を取得(json)
			HttpUriRequest httpGet = new HttpGet(URL);
			DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
			HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			
			// json 解析
			String json = EntityUtils.toString(entity);
			Gson gson = new GsonBuilder().serializeNulls().create();
			GoogleMapper mapper = gson.fromJson(json, GoogleMapper.class);

			List<Results> results = mapper.getResults();
			if (results != null) {
				for (Results r : results) {
					System.out.println("Fetched name: " + r.getName());
				}
			}

		} catch (IOException e) {
			System.out.println("通信失敗");
		}
	}
}

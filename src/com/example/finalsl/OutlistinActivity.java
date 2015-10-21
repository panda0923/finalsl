package com.example.finalsl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutlistinActivity extends Activity {
	EditText edit_entname,edit_entspot,edit_enttel,edit_entempname;
	Button btn_inent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_outlistin);
		
		edit_entname = (EditText)findViewById(R.id.edit_entname);
		edit_entspot = (EditText)findViewById(R.id.edit_entspot);	
		edit_enttel = (EditText)findViewById(R.id.edit_enttel);
		edit_entempname = (EditText)findViewById(R.id.edit_entempname);
		btn_inent = (Button)findViewById(R.id.btn_inent);
		btn_inent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String entname = edit_entname.getText().toString();
				String entspot = edit_entspot.getText().toString();
				String enttel = edit_enttel.getText().toString();
				String entempname = edit_entempname.getText().toString();
				String requestURL = "http://localhost:8088/FinalSlWeb/views/user/insert.jsp";
				InputStream is = requestGet(requestURL,entname,entspot,enttel,entempname);
				
			}
		});
	
	}
	protected InputStream requestGet(String requestURL, String entname,
			String entspot, String enttel, String entempname) {

		Log.i("xxx", "requestGet start");
		try{
			
		//1.
			HttpClient client =new DefaultHttpClient();
			
		//폼데이터 저장
		List<NameValuePair> dataList = new ArrayList<NameValuePair>();
		dataList.add(new BasicNameValuePair("entname",entname));
		dataList.add(new BasicNameValuePair("entspot",entspot));
		dataList.add(new BasicNameValuePair("enttel",enttel));
		dataList.add(new BasicNameValuePair("entempname",entempname));
		requestURL = requestURL+"?"+ URLEncodedUtils.format(dataList, "UTF-8");
		
		HttpGet get = new HttpGet(requestURL);
		
		//2.요청
		HttpResponse response = client.execute(get);
		
		//3.결과 받기
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		return is;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
	

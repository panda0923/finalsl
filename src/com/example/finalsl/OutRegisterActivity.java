package com.example.finalsl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class OutRegisterActivity extends Activity implements OnItemClickListener {

	 String[] data = {"�ܱ�/������ "};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_register);
		
		ListView list = (ListView) findViewById(R.id.list_view);
		ArrayAdapter<String> adapter 
        = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		 list.setAdapter(adapter);
		 list.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_register, menu);
		return true;
	}

	 @Override
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	        
	        //���̾�α׿� ������ ����
	        final String[] classData = {"�Ｚ", "LG", "����"};
	        final String title = ((TextView) arg1).getText().toString();
	        //���̾�α� ����
	        new AlertDialog.Builder(this).setTitle(title +"�����ϼ���.")
	        .setItems(classData,new DialogInterface.OnClickListener(){

	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                System.out.println("++++"+which);
	                Toast.makeText(getApplicationContext(), title+":" +which+"."+classData[which], Toast.LENGTH_SHORT).show();
	                
	            }
	            
	            
	        }).setNegativeButton("",null).show();
	        
	    }

	}
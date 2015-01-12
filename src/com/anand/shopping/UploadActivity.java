package com.anand.shopping;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UploadActivity extends Activity {
	public static String name="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.upload);






	}
	public void upload(View v)
	{
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		Editor ed=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
		//		int id_saved=sp.getInt("pid", 0);
		//		if(id_saved==0)
		//		{
		//			Editor e=sp.edit();
		//			e.putInt("pid", 1);
		//		}
		//		else
		//		{
		//			int id_now=id_saved+1;
		//			Editor e=sp.edit();
		//			e.putInt("pid",id_now);
		//		}
		//		id_saved=sp.getInt("pid", 0);
		EditText prdtid_entered=(EditText)findViewById(R.id.editText1);
		String prdtid_enter=prdtid_entered.getText().toString();
		int prdtid=Integer.parseInt(prdtid_enter);

		EditText prdtname_entered=(EditText)findViewById(R.id.prdtname_text);
		String prdtname_enter=prdtname_entered.getText().toString();
		//
		EditText prdtqty_entered=(EditText)findViewById(R.id.prdtqnty_text);
		String prdtqty_enter=prdtqty_entered.getText().toString();
		int prdtqty=Integer.parseInt(prdtqty_enter);
		//
		EditText prdtprice_entered=(EditText)findViewById(R.id.prdtprice_text);
		String prdtprice_enter=prdtprice_entered.getText().toString();
		int prdtprc=Integer.parseInt(prdtprice_enter);

		String allprdts=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).getString("productlist", "");
		if(allprdts.contains(prdtid_enter)){
			StringTokenizer stk=new StringTokenizer(allprdts, "|");
			StringTokenizer stk2=null;
			int no_of_prdts = stk.countTokens();
			String id="";
			for (int i = 0; i < no_of_prdts; i++) {
				stk2=new StringTokenizer(stk.nextToken(), ",");
				id=(stk2.nextToken());
				if(id.equalsIgnoreCase(prdtid_enter)){
					Toast.makeText(getApplicationContext(), "Product ID Already exists! \n Please enter new product ID.", Toast.LENGTH_LONG).show();
					return;
				}
			}
		}

		String productvalues=prdtid+","+prdtname_enter+","+prdtqty+","+prdtprc;
		if(! sp.getString("productlist", "").equals("")){
			//already some registered
			productvalues=sp.getString("productlist", "") + "|" +productvalues;
		}
		ed.putString("productlist", productvalues);
		ed.commit();

		Toast.makeText(getApplicationContext(), "Upload Successfully",Toast.LENGTH_LONG).show();



	}
	public void home(View v)
	{
		startActivity(new Intent(this,AdminHomeActivity.class));
	}

}

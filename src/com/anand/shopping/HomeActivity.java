package com.anand.shopping;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {
	public static String name="";
	Thread th=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home);

		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		name=sp.getString("name","");

		TextView names=(TextView)findViewById(R.id.name_text);
		names.setText(name);




	}
	public void prdtview(View v)
	{
		startActivity(new Intent(this,PrdtActivity.class));
	}
	public void logout(View v)
	{

		Editor e=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).edit();
		e.putString("username", "");
		e.putString("password", "");
		e.putString("name", "");
		e.putString("email", "");
		e.putLong("phone", 0l);
		e.putBoolean("login_status", false);
		e.commit();

		startActivity(new Intent(this,MainActivity.class));
		finish();
	}
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(HomeActivity.this)
		.setTitle("Exit")
		.setMessage("Do you want to Exit the Application?")
		.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// Show the ProgressDialog on this thread
				finish();
			}
		}).setNegativeButton("NO", 	new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				return;
			}
		}).show();          

		//super.onBackPressed();
	}
}

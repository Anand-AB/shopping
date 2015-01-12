package com.anand.shopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomeActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.adminhome);
	}
	public void prdtview(View v)
	{
		startActivity(new Intent(this,UploadActivity.class));
	}
	public void logout(View v)
	{
		startActivity(new Intent(this,MainActivity.class));
		finish();
	}
}

package com.anand.shopping;



import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

	}
	public void loged(View v)
	{
		//		EditText username_entered=(EditText)findViewById(R.id.username_edit);
		//		String username_enter=username_entered.getText().toString();
		//
		//
		//		EditText password_entered=(EditText)findViewById(R.id.password_edit);
		//		String password_enter=password_entered.getText().toString();
		//
		//		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());//Data Edit
		//		String username_saved=sp.getString("username","");
		//		String password_saved=sp.getString("password","");
		//		String name_saved=sp.getString("name","");
		//
		//		if(username_saved.equalsIgnoreCase(username_enter))
		//		{
		//			if(password_saved.equals(password_enter))
		//			{
		//				HomeActivity.name=name_saved;
		//				startActivity(new Intent(this,HomeActivity.class));
		//			}
		//			else {
		//
		//				Toast.makeText(getApplicationContext(),"Password Error",Toast.LENGTH_LONG).show();
		//
		//			}
		//		}
		//		else{
		//
		//			Toast.makeText(getApplicationContext(),"Invalid user please Register First",Toast.LENGTH_LONG).show();
		//			startActivity(new Intent(this,RegisterActivity.class));
		//		}

		EditText edit_user=(EditText)findViewById(R.id.username_edit);
		EditText edit_pass=(EditText)findViewById(R.id.password_edit);

		String username_entered=edit_user.getText().toString();
		String password_entered=edit_pass.getText().toString();

		boolean loginStatus=false;
		
		if(username_entered.equalsIgnoreCase("admin") && password_entered.equals("admin"))
		{
			startActivity(new Intent(this, AdminHomeActivity.class));
			finish();
		}
		else{

		String alluser=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).getString("previous_registrations", "");
		if(alluser.contains(username_entered)){
			StringTokenizer stk=new StringTokenizer(alluser, "|");
			StringTokenizer stk2=null;
			int no_of_users = stk.countTokens();
			String usename="";
			String passw="";

			for (int i = 0; i < no_of_users; i++) {
				stk2=new StringTokenizer(stk.nextToken(), ",");
				usename=(stk2.nextToken());
				passw=(stk2.nextToken());
				//				name=(stk2.nextToken());
				//				mail=(stk2.nextToken());
				//				phone=(stk2.nextToken());
				//				photo=(stk2.nextToken());
				if(usename.equalsIgnoreCase(username_entered) && passw.equals(password_entered)){
					loginStatus=true;
					Editor e=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).edit();
					e.putString("username", username_entered);
					e.putString("password", password_entered);
					e.putString("name", stk2.nextToken());
					e.putString("email", stk2.nextToken());
					e.putLong("phone",Long.parseLong(stk2.nextToken()));
					e.commit();
					break;
				}

			}
		}else{
			Toast.makeText(getApplicationContext(), "User doesn\'t Exist  Register First.", Toast.LENGTH_LONG).show();
			startActivity(new Intent(this, RegisterActivity.class));
			finish();
			return;
		}
		if(loginStatus){
			Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();

			startActivity(new Intent(this, HomeActivity.class));
			finish();
		}else{
			Toast.makeText(getApplicationContext(), "Login Failed\n Enter correct Username and Password.", Toast.LENGTH_LONG).show();
		}

	}


}
}



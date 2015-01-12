package com.anand.shopping;

import java.util.StringTokenizer;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

public class PrdtActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.prdtlist);

		ListView myListView = (ListView) findViewById(R.id.my_main_listview);


		UserAdapter myUserAdapter=new UserAdapter(getApplicationContext(), createDummyUserModels());


		myListView.setAdapter(myUserAdapter);

	}
	public UserModel[] createDummyUserModels(){

		//	int[] ids={1,2,3,4,5,6,7,8,9,10};
		//String[] pnames={"cap","watch","tv","mobile","bags", "shoes","books","spray","computer", "ac"};
		//int[] qtys={5,2,8,10,4,3,7,15,6,9};
		//int[] prices={30,150,5000,80000,350,200,80,100,50000,25000};

		String prodts=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).getString("productlist", "");
		StringTokenizer stk=new StringTokenizer(prodts, "|");
		StringTokenizer stk2=null;
		int no_of_prdts = stk.countTokens();
		String[] ids = new String[no_of_prdts];
		String[] pnames = new String[no_of_prdts];
		String[] qtys = new String[no_of_prdts];
		String[] prices = new String[no_of_prdts];
		for (int i = 0; i < no_of_prdts; i++) {
			stk2=new StringTokenizer(stk.nextToken(), ",");
			ids[i]=((stk2.nextToken()));


			pnames[i]=(stk2.nextToken());
			qtys[i]=((stk2.nextToken()));
			prices[i]=((stk2.nextToken()));
			//				phone=(stk2.nextToken());
			//				photo=(stk2.nextToken());
			//				if(usename.equalsIgnoreCase(username_entered) && passw.equals(password_entered)){
			//					loginStatus=true;
			//					Editor e=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).edit();
			//					e.putString("username", username_entered);
			//					e.putString("password", password_entered);
			//					e.putString("name", stk2.nextToken());
			//					e.putString("email", stk2.nextToken());
			//					e.putLong("phone",Long.parseLong(stk2.nextToken()));
			//					e.commit();
			//					break;
		}
		UserModel[] userlist=new UserModel[ids.length];
		for (int i = 0; i < ids.length; i++) {
			userlist[i]=new UserModel(Integer.parseInt(ids[i]),pnames[i],Integer.parseInt(qtys[i]),Integer.parseInt(prices[i]));
		}
		return userlist;

	}



}





package com.anand.shopping;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<UserModel>{

	UserModel[] usersList;
	Context myContext;

	public UserAdapter(Context context, UserModel[] usersList) {
		super(context, R.layout.list_item, usersList);
		this.usersList=usersList;
		this.myContext=context;
	}

	// It gets a View that displays in the drop down popup the data at the specified position
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	// It gets a View that displays the data at the specified position
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}


	private View getCustomView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater mLayoutInflater = LayoutInflater.from(myContext);
			convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
		}

		TextView pidTextView = (TextView) convertView.findViewById(R.id.prdtid);
		TextView pnameTextView = (TextView) convertView.findViewById(R.id.prdtname);
		TextView pqtyTextView = (TextView) convertView.findViewById(R.id.prdtqty);
		TextView prsTextView = (TextView) convertView.findViewById(R.id.prdtprice);
		//		ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView_photo);


		pidTextView.setText(usersList[position].getId()+"");
		pnameTextView.setText(usersList[position].getName());
		pqtyTextView.setText(usersList[position].getQty()+"");
		prsTextView.setText(usersList[position].getPrice()+"");

		return convertView;
	}
}

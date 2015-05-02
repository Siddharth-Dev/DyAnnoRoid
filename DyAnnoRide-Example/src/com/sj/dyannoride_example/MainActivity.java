package com.sj.dyannoride_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.sj.dyannoroid.DyAnnoRideActivity;
import com.sj.dyannoroid.ScreenBase;
import com.sj.dyannoroid.annotations.Initialize;
import com.sj.dyannoroid.annotations.RelativeParameter;

public class MainActivity extends DyAnnoRideActivity {

	@Initialize(id = R.id.title) 
	@RelativeParameter( base = ScreenBase.HEIGHT, marginLeft = 8, marginTop = 5, marginRight = 5, marginBottom = 5)
	TextView title;
	@Initialize(id = R.id.subHeading)
	@RelativeParameter( base = ScreenBase.HEIGHT, marginLeft = 5, marginRight = 5, marginBottom = 5)
	TextView subHeading;
	@Initialize(id = R.id.text)
	@RelativeParameter( base = ScreenBase.HEIGHT, marginLeft = 5, marginRight = 5, marginBottom = 5)
	TextView text;
	@Initialize(id = R.id.submit)
	@RelativeParameter( base = ScreenBase.WIDTH, marginTop = 10, width = 80, height = 35)
	Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Using the views without initializing them explicitly as the annotation will do that.
		title.setText(getString(R.string.title));
		subHeading.setText(getString(R.string.sub_heading));
		text.setText(getString(R.string.text));
		
		btn.setBackgroundResource(android.R.drawable.button_onoff_indicator_on);
	}
}

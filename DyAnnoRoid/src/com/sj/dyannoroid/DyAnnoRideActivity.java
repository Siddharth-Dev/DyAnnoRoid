package com.sj.dyannoroid;

import com.sj.dyannoroid.viewproperties.ViewInjector;

import android.app.Activity;
import android.os.Bundle;

public class DyAnnoRideActivity extends Activity{

	private ViewInjector injector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		injector = new ViewInjector(this);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		injector.intiliseViews();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		injector.applyAnnotations();
	}
}

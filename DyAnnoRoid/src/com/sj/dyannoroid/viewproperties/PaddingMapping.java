package com.sj.dyannoroid.viewproperties;

import android.util.DisplayMetrics;
import android.view.View;

import com.sj.dyannoroid.ScreenBase;
import com.sj.dyannoroid.annotations.PaddingParameter;

class PaddingMapping {
	private PaddingParameter parameter;
	private View view;
	private DisplayMetrics displayMetrics;
	
	public PaddingMapping(DisplayMetrics displayMetrics, PaddingParameter parameter, View view) {
		this.displayMetrics = displayMetrics;
		this.parameter = parameter;
		this.view = view;
	}
	
	public void map(){
		if(parameter == null || view == null)
			return;
		int base ;
		if(parameter.base() == ScreenBase.HEIGHT){
			base = displayMetrics.heightPixels;
		}else{
			base = displayMetrics.widthPixels;
		}
		
		int paddingLeft = view.getPaddingLeft();
		int paddingRight = view.getPaddingRight();
		int paddingTop = view.getPaddingTop();
		int paddingBottom = view.getPaddingBottom();
		
		if (parameter.paddingBottom() > 0) {
			paddingBottom = (int) (base
					* (float) parameter.paddingBottom() / 100);
		}
		if (parameter.paddingLeft() > 0) {
			paddingLeft = (int) (base
					* (float) parameter.paddingLeft() / 100);
		}
		if (parameter.paddingRight() > 0) {
			paddingRight = (int) (base
					* (float) parameter.paddingRight() / 100);
		}
		if (parameter.paddingTop() > 0) {
			paddingTop = (int) (base
					* (float) parameter.paddingTop() / 100);
		}
		view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
		
	}
}

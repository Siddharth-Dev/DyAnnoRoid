package com.sj.dyannoroid.viewproperties;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

import com.sj.dyannoroid.ScreenBase;
import com.sj.dyannoroid.annotations.FrameParameter;

class FrameParamMapping {
	private FrameParameter parameter;
	private View view;
	private DisplayMetrics displayMetrics;
	
	public FrameParamMapping(DisplayMetrics displayMetrics, FrameParameter parameter, View view) {
		this.displayMetrics = displayMetrics;
		this.parameter = parameter;
		this.view = view;
	}
	
	public void map(){
		if(parameter == null || view == null)
			return;
		FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view
				.getLayoutParams();
		int base ;
		if(parameter.base() == ScreenBase.HEIGHT){
			base = displayMetrics.heightPixels;
		}else{
			base = displayMetrics.widthPixels;
		}
		
		if (parameter.height() > 0) {
			layoutParams.height = (int) (base
					* (float) parameter.height() / 100);
		}
		if (parameter.width() > 0) {
			layoutParams.width = (int) (base
					* (float) parameter.width() / 100);
		}
		if (parameter.marginBottom() > 0) {
			layoutParams.bottomMargin = (int) (base
					* (float) parameter.marginBottom() / 100);
		}
		if (parameter.marginLeft() > 0) {
			layoutParams.leftMargin = (int) (base
					* (float) parameter.marginLeft() / 100);
		}
		if (parameter.marginRight() > 0) {
			layoutParams.rightMargin = (int) (base
					* (float) parameter.marginRight() / 100);
		}
		if (parameter.marginTop() > 0) {
			layoutParams.topMargin = (int) (base
					* (float) parameter.marginTop() / 100);
		}
		view.setLayoutParams(layoutParams);
		
	}
}

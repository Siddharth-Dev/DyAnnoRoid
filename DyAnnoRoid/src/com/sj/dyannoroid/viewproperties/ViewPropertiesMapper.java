package com.sj.dyannoroid.viewproperties;

import java.lang.annotation.Annotation;

import android.util.DisplayMetrics;
import android.view.View;

import com.sj.dyannoroid.annotations.FrameParameter;
import com.sj.dyannoroid.annotations.LinearParameter;
import com.sj.dyannoroid.annotations.PaddingParameter;
import com.sj.dyannoroid.annotations.RelativeParameter;

class ViewPropertiesMapper {

	private Annotation annotation;
	private View view;
	private DisplayMetrics displayMetrics;
	
	public ViewPropertiesMapper(Annotation annotation, View view, DisplayMetrics displayMetrics) {
		this.annotation = annotation;
		this.view = view;
		this.displayMetrics = displayMetrics;
	}
	
	public void applyProperties(){
		if(annotation instanceof RelativeParameter){
			RelativeMapping relativeMapping = new RelativeMapping(displayMetrics, (RelativeParameter) annotation, view);
			relativeMapping.map();
		}else if( annotation instanceof LinearParameter){
			LinearMapping linearMapping = new LinearMapping(displayMetrics, (LinearParameter)annotation, view);
			linearMapping.map();
		}else if( annotation instanceof FrameParameter){
			FrameParamMapping frameParamMapping = new FrameParamMapping(displayMetrics, (FrameParameter)annotation, view);
			frameParamMapping.map();
		}else if( annotation instanceof PaddingParameter){
			PaddingMapping paddingMapping = new PaddingMapping(displayMetrics, (PaddingParameter)annotation, view);
			paddingMapping.map();
		}
	}
}

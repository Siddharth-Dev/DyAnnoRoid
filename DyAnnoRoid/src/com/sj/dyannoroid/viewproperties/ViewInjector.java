package com.sj.dyannoroid.viewproperties;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import com.sj.dyannoroid.DyAnnoRideActivity;
import com.sj.dyannoroid.ScreenBase;
import com.sj.dyannoroid.annotations.Initialize;
import com.sj.dyannoroid.annotations.RelativeParameter;

public class ViewInjector {

	private DyAnnoRideActivity viewActivity;
	private DisplayMetrics displayMetrics;

	public ViewInjector(Context context) {
		viewActivity = (DyAnnoRideActivity) context;
		displayMetrics = context.getResources().getDisplayMetrics();
	}

	public void intiliseViews() {
		for (Field field : viewActivity.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Initialize.class)) {
				Initialize initialize = field.getAnnotation(Initialize.class);
				View view = viewActivity.findViewById(initialize.id());
				try {
					if (view != null) {
						field.setAccessible(true);
						field.set(viewActivity, view);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void applyAnnotations() {
		for (Field field : viewActivity.getClass().getDeclaredFields()) {

			Annotation[] annotations = field.getAnnotations();

			for (Annotation annotation : annotations) {
				if (annotation instanceof RelativeParameter) {
					try {
						field.setAccessible(true);
						if (field.get(viewActivity) instanceof View) {
							View view = (View) field.get(viewActivity);
							RelativeParameter parameter = (RelativeParameter) annotation;
							RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
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
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

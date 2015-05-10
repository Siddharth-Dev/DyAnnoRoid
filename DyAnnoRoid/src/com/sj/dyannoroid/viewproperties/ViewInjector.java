package com.sj.dyannoroid.viewproperties;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import com.sj.dyannoroid.DyAnnoRideActivity;
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
				try {
					field.setAccessible(true);
					if (field.get(viewActivity) instanceof View) {
						View view = (View) field.get(viewActivity);
						ViewPropertiesMapper mapper = new ViewPropertiesMapper(
								annotation, view, displayMetrics);
						mapper.applyProperties();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

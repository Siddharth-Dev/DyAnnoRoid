package com.sj.dyannoroid.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sj.dyannoroid.ScreenBase;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FrameParameter {
	ScreenBase base() default ScreenBase.HEIGHT;
	int width() default -1;
	int height() default -1;
	int marginRight() default -1;
	int marginLeft() default -1;
	int marginTop() default -1;
	int marginBottom() default -1;
}

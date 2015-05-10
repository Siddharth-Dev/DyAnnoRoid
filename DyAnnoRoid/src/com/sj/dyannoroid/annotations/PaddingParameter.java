package com.sj.dyannoroid.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sj.dyannoroid.ScreenBase;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PaddingParameter {
	ScreenBase base() default ScreenBase.HEIGHT;
	int paddingRight() default -1;
	int paddingLeft() default -1;
	int paddingTop() default -1;
	int paddingBottom() default -1;
}

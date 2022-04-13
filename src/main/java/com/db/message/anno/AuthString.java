package com.db.message.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author DB
 * @title: AuthString
 * @projectName message
 * @description: TODO
 * @date 2022/2/28  16:59
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthString {
    String value() default "";
}

package com.futurelinkgrp.lingyi.annotation;

import java.lang.annotation.*;

/**
 * Created by lchen on 8/28/2017.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation1 {
    String value();

}

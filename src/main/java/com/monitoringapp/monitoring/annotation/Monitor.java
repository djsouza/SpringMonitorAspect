package com.monitoringapp.monitoring.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Monitor {
    long maxTime() default -1L;
    boolean monitorExceptions() default true;
}

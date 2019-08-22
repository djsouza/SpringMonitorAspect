package com.monitoringapp.monitoring.event;

import org.springframework.context.ApplicationEvent;

public class ExceptionEvent extends ApplicationEvent {

    private String className;

    private String methodName;

    private Throwable throwable;

    private Object source;

    public static ExceptionEvent of(Object source, String className, String methodName, Throwable throwable) {
        return new ExceptionEvent(source, className, methodName, throwable);
    }

    public ExceptionEvent(Object source, String className, String methodName, Throwable throwable) {
        super(source);
        this.className = className;
        this.methodName = methodName;
        this.throwable = throwable;
        this.source = source;
    }
}

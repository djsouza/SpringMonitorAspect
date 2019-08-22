package com.monitoringapp.monitoring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

public @Data class TimeExceededEvent extends ApplicationEvent {

    private String className;

    private String methodName;

    private Long expected;

    private Long actual;

    private Object source;

    public static TimeExceededEvent of(Object source, String className, String methodName, Long expected, Long actual) {
        return new TimeExceededEvent(source, className, methodName, expected, actual);
    }

    public TimeExceededEvent(Object source, String className, String methodName, Long expected, Long actual) {
        super(source);
        this.className = className;
        this.methodName = methodName;
        this.expected = expected;
        this.actual = actual;
    }

}

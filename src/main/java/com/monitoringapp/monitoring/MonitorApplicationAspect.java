package com.monitoringapp.monitoring;

import com.monitoringapp.monitoring.annotation.Monitor;
import com.monitoringapp.monitoring.event.ExceptionEvent;
import com.monitoringapp.monitoring.event.TimeExceededEvent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class MonitorApplicationAspect {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Around("@annotation(com.monitoringapp.monitoring.annotation.Monitor)")
    public Object monitor(ProceedingJoinPoint  joinPoint) throws Throwable {

        Monitor monitor = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(com.monitoringapp.monitoring.annotation.Monitor.class);
        Object proceed = null;

        try {

            Instant start = Instant.now();
            proceed = joinPoint.proceed();
            Instant end = Instant.now();

            // Elapsed time
            Long elapsedTime = Duration.between(start, end).toMillis();

            if(monitor.maxTime() > 0) {

                if(elapsedTime > monitor.maxTime()) {

                    applicationEventPublisher.publishEvent(TimeExceededEvent.of(this,
                            joinPoint.getSignature().getDeclaringType().toString(),
                            joinPoint.getSignature().getName(),
                            monitor.maxTime(),
                            elapsedTime));

                }

            }

        } catch (Throwable e) {

            if(monitor.monitorExceptions()) {
                applicationEventPublisher.publishEvent(ExceptionEvent.of(this,
                                joinPoint.getSignature().getDeclaringType().toString(),
                                joinPoint.getSignature().getName(),
                                e));
            }

            throw e;
        }

        return proceed;

    }

}

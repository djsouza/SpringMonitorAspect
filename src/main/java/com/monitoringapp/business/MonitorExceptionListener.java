package com.monitoringapp.business;

import com.monitoringapp.monitoring.event.ExceptionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MonitorExceptionListener implements ApplicationListener<ExceptionEvent> {

    @Override
    public void onApplicationEvent(ExceptionEvent event) {

    }

}

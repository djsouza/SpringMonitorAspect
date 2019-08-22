package com.monitoringapp.business;

import com.monitoringapp.monitoring.event.TimeExceededEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MonitorTimeExceededListener  implements ApplicationListener<TimeExceededEvent> {

    @Override
    public void onApplicationEvent(TimeExceededEvent event) {

    }

}

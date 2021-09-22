package com.sachin.scheduler.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleProperties {
    @Value("scheduler.cron.interval")
    private String interval;

}

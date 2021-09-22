package com.sachin.scheduler.task;

import com.sachin.scheduler.properties.SampleProperties;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Component
//@Slf4j
public class SampleTask {
    private final SampleProperties sampleProperties;

    public SampleTask(SampleProperties sampleProperties) {
        this.sampleProperties = sampleProperties;
    }

    public void initTask() throws IOException, ExecutionException, InterruptedException
    {
        System.out.println("scheduled job triggered");


    }
}

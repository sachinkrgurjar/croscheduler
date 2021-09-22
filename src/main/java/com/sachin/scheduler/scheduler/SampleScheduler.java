package com.sachin.scheduler.scheduler;

import com.sachin.scheduler.properties.SampleProperties;
import com.sachin.scheduler.task.SampleTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


@Component
//@Slf4j
@Configuration
@PropertySource("classpath:application.yml")
public class SampleScheduler {
    private final SampleTask sampleTask;
    private final SampleProperties sampleProperties;
    @Value("${aa.bb}")
    private String interval;


    public SampleScheduler(SampleTask sampleTask, SampleProperties sampleProperties) {
        this.sampleTask = sampleTask;
        this.sampleProperties = sampleProperties;
        //this.interval = interval;
    }

    public  void doPrint()
    {
        System.out.println("interval is" + interval);
    }
   //@Scheduled(cron = "*/30 * * * * *", zone = "Asia/Singapore")
   @Scheduled(cron = ("${scheduler.cron.interval}"), zone = "${scheduler.cron.timezone}")
    public void scheduleJob() throws InterruptedException, ExecutionException {

        try {
            doPrint();
            sampleTask.initTask();
          //  log.info("processing file:" + sampleProperties.getProcessFile());

        } catch (IOException e) {//log.error("Error during scheduling:"+ e.getMessage());}
        }
    }

}

package com.renyuwo.alamp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//用于设置任务间隔
	@Scheduled(cron="0/10 * * * * *")
	public void doSomething() {
        logger.info("doSomething");
    }
}

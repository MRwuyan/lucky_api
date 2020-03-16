package com.exhk.robot.order.schedule;

import com.exhk.robot.order.service.LuckyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ScheduleTask {
    @Autowired
    LuckyService luckyService;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void refush() {
        luckyService.refush();
    }

}

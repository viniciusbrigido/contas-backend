package com.brigido.contas.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduler {

    @Autowired
    private CurrencySchedule currencySchedule;

    @Scheduled(cron = "0 0 0 * * *")
    public void myScheduledTask() {
        currencySchedule.currencySchedule();
    }
}

package com.cricinfo.livescore.scheduler;

import com.cricinfo.livescore.service.LiveScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ ={@Autowired} )
public class LiveScoreScheduler {

    private final LiveScoreService liveScoreService;

    @PostConstruct
    public void onStartup() {
        liveScoreService.fetchAndStoreLiveScoreData();
    }

    @Scheduled(cron = "* */5 * * * *", zone = "Asia/Dhaka")
    public void fetchData(){
        log.info("Live score scheduler " + new Date());

        liveScoreService.fetchAndStoreLiveScoreData();

    }

}

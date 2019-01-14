package com.brs.oa.comm.schedule;

import com.brs.oa.ad.service.AdService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author tiny lin
 * @date 2018/12/25
 */
@Component
public class DbSchedulerTask {
    final static Logger LOGGER = LoggerFactory.getLogger(DbSchedulerTask.class);
    @Autowired
    private AdService adService;

    /**
     * 明天晚上24点同步ad数据到mysql中
     */
    @Scheduled(cron = "0 0 23 * * ?")
    private void process(){
        adService.synchronizeStaffInfo();
        LOGGER.info("##this is scheduler task runing......synchronizeStaffInfo.. ...>");
    }
}

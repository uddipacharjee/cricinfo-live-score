package com.cricinfo.livescore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cricinfo.livescore.repository",repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class LiveScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiveScoreApplication.class, args);
    }

}

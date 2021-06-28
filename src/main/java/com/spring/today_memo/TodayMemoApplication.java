package com.spring.today_memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodayMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodayMemoApplication.class, args);
    }

}

package com.example.levan.spring_security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.example.levan.spring_security")
public class SpringSecurityApplication {

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(SpringSecurityApplication.class, args).getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        if (appName != null) {
            appName = appName.toUpperCase();
        }
        String port = environment.getProperty("server.port");
        log.info("===================START {} Application====================", appName);
        log.info("\tApplication      : {}", appName);
        log.info("\tUrl Swagger-Ui   : http://localhost:{}/swagger-ui.html", port);
        log.info("====================START SUCCESS {} APPLICATION====================", appName);
    }

}

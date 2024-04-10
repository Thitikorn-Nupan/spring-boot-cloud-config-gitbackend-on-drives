package com.ttknpdev.server;

import com.ttknpdev.server.logging.LogBack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // With this annotation, this artifact will act like a spring config server.
public class GitbackendServerOnDriverApplication {

    private static LogBack logBack = new LogBack(GitbackendServerOnDriverApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(GitbackendServerOnDriverApplication.class, args);
        logBack.log.info("Gitbackend server is running");
    }

}

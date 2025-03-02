package com.ttknpdev.server;

import com.ttknpdev.server.logging.LogBack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer // With this annotation, this artifact will act like a spring config server.
@RestController
public class GitbackendServerOnDriverApplication {

    // private static LogBack logBack = new LogBack(GitbackendServerOnDriverApplication.class);


    @GetMapping(value = "/server")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String server() {
        return "Gitbackend server is running on port 8888";
    }

    public static void main(String[] args) {
        SpringApplication.run(GitbackendServerOnDriverApplication.class, args);
    }

}

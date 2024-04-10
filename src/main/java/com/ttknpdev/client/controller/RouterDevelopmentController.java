package com.ttknpdev.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/development")
@RefreshScope
public class RouterDevelopmentController {

    @Value("${git.server.message:Config Server is not working.}") // it will go ahead to gitbackend-on-driver.properties because it found message first
    private String message;
    @Value("${git.server.port:Config Server is not working.}") // it will go ahead to gitbackend-on-driver-development.properties
    private String port;
    @Value("${git.server.domain:Config Server is not working.}") // go ahead to gitbackend-on-driver-development.properties too
    private String domain;

    @GetMapping("/message")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/port")
    public ResponseEntity<String> getPort() {
        return ResponseEntity.ok().body(port);
    }

    @GetMapping("/domain")
    public ResponseEntity<String> getDomain() {
        return ResponseEntity.ok().body(domain);
    }
}

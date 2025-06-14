package com.chatapp.realchat.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HelloController {


    @GetMapping("/echo")
    public Map<String, String> echoMessage(@RequestParam(required = false) String message) {
        return Map.of("echo", message != null ? message : "No message provided");
    }


    // 4. Health check endpoint (for is_port_healthy())
    @GetMapping("/healthcheck")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}

package com.chatapp.realchat.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    // 1. Simple greeting
    @GetMapping("/hello1")
    public Map<String, String> sayHello() {
        return Map.of("message", "Hello from RealChat!");
    }

    
    
    // 2. Welcome user
    @GetMapping("/welcome1")
    public Map<String, String> welcomeUser() {
        return Map.of("status", "success", "message", "Welcome to the Chat App!");
    }

    // 3. App info
    @GetMapping("/info1")
    public Map<String, String> getAppInfo() {
        return Map.of(
            "app", "RealChat",
            "version", "1.0",
            "author", "Khagesh"
        );
    }
    
    // 4. Health check endpoint (for is_port_healthy())
    @GetMapping("/healthcheck")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}

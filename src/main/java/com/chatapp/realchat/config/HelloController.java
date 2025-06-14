package com.chatapp.realchat.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    
    // 4. Health check endpoint (for is_port_healthy())
    @GetMapping("/healthcheck")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}

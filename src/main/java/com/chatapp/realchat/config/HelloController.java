package com.chatapp.realchat.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

  @GetMapping("/time")
    public Map<String, String> getCurrentTime() {
        return Map.of("serverTime", LocalDateTime.now().toString());
    }

    @GetMapping("/echo")
    public Map<String, String> echoMessage(@RequestParam(required = false) String message) {
        return Map.of("echo", message != null ? message : "No message provided");
    }

    @GetMapping("/contact")
    public Map<String, String> getContactInfo() {
        return Map.of(
            "email", "support@realchat.com",
            "phone", "+91-9876543210"
        );
    }
    // 4. Health check endpoint (for is_port_healthy())
    @GetMapping("/healthcheck")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}

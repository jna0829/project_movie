package com.example.project_D;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthyCheckController {

    @GetMapping("/")
    public String check() {
        log.info("server in running...");
        return "server in running...";
    }

}
package com.pramod.ratelimiterusingredis.Controller;

import com.pramod.ratelimiterusingredis.service.RateLimiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalTime.now;


@RestController("RateLimiterControllerRedis")

@AllArgsConstructor
public class RateLimiterController {

    private final RateLimiteService service;


    @GetMapping("/testRedis")
    public boolean rateLimiter(String clientId) {
        return service.isAllowed(clientId);
    }

    }



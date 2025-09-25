package com.pramod.ratelimiterusingBucket.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("RateLimiterControllerBucketJar")

public class RateLimiterController {


    @GetMapping("/testBucket")
    public String rateLimiter() {
        return "Here is the protected data!";
    }


    }



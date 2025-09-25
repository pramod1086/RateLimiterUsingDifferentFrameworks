package com.pramod.ratelimitusingexectorframework.TocketBucketManager;

import com.pramod.ratelimitusingexectorframework.model.Bucket;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.util.RateLimiter;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;


@Configuration

public class TocketBucketManager {
    private Bucket bucket;
    private ConcurrentHashMap<String, RateLimiter> rateLimiters;
    @PostConstruct
    public void init() {
        bucket = new Bucket();

    }
}

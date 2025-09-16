package com.pramod.ratelimiterusingBucket.config;


import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.apache.catalina.util.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {

    @Bean
    public Bucket rateLimiter() {
        Bandwidth bandwidth = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));

        return Bucket4j.builder().addLimit(bandwidth).build();
    }
}

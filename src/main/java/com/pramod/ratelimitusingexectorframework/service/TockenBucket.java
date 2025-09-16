package com.pramod.ratelimitusingexectorframework.service;

import org.apache.catalina.util.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class TockenBucket {

    private String BucketName;

    public synchronized void tryConsume(int  requested) {
        if(requested <=0){
            throw new IllegalArgumentException("requested should be greater than 0");
        }
//        refill()
    }
}

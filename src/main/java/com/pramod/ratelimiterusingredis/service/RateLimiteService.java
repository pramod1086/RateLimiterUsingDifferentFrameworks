package com.pramod.ratelimiterusingredis.service;

public interface RateLimiteService {
    public boolean isAllowed(String clientId) ;
}

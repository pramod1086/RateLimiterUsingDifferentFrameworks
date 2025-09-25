package com.pramod.ratelimiterusingredis.service;

import com.pramod.ratelimiterusingredis.Controller.Bucket;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RateLimiteServiceImpl implements RateLimiteService{

    private final RedisTemplate redisTemplate;

    public boolean isAllowed(String clientId) {
        Boolean flag = Boolean.FALSE;
        String keyCount = "rate_limit:" + clientId + ":count";
        String keyLastRefill = "rate_limit:" + clientId + ":lastRefill";

        Bucket cachedProduct = (Bucket) redisTemplate.opsForValue().get(clientId);

        long currentTimeMillis = System.currentTimeMillis();

        if(cachedProduct == null){
            cachedProduct = new Bucket();
            cachedProduct.setMaxAmount(3);
            cachedProduct.setRefillTime(2);
            cachedProduct.setKey(clientId);
            cachedProduct.setLastUpdate(currentTimeMillis);
        }
       long  time = (currentTimeMillis - cachedProduct.getLastUpdate())/ 1000 / 60;

        if((time > 2) && cachedProduct.getValue()<cachedProduct.getMaxAmount()){
            flag = Boolean.TRUE.booleanValue();
            cachedProduct.setValue(cachedProduct.getValue()+1);

        }
        redisTemplate.opsForValue().set(clientId, cachedProduct);
        return flag;


    }
    public void refill(String clientId) {
            long currentTimeMillis = System.currentTimeMillis();
            Bucket  product = new Bucket();
            product.setMaxAmount(1);
            product.setRefillTime(2);
            product.setKey(clientId);
            product.setLastUpdate(currentTimeMillis);

    }
}

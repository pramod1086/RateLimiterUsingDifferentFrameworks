package com.pramod.ratelimiterusingredis.redis;


import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.List;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;

    }
//
//    @Bean
//    RedisConnectionFactory redisConnectionFactory() {
//        // ...
//    }

    @Bean
    RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(5))
                .enableTimeToIdle();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaults)
                .build();
    }


//    @Bean
//        public void MyBean(ApplicationArguments args) {
//            boolean debug = args.containsOption("debug");
//            List<String> files = args.getNonOptionArgs();
//            if (debug) {
//                System.out.println(files);
//            }
//            // if run with "--debug logfile.txt" prints ["logfile.txt"]
//        }


}

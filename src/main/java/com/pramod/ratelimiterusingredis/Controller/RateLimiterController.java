//package com.pramod.ratelimiterusingredis.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//
//import static java.lang.Math.floor;
//import static java.time.LocalTime.now;
//
//
//@RestController
//
//public class RateLimiterController {
//
//
//    @GetMapping
//    public String rateLimiter() {
//        createRedis();
//        update();
//        return "Hello World!";
//    }
//
//    public void createRedis(){
//        RedisURI uri = RedisURI.Builder
//                .redis("localhost", 6379)
//                .build();
//
//        RedisClient client = RedisClient.create(uri);
//        StatefulRedisConnection<String, String> connection = client.connect();
//        RedisCommands<String, String> commands = connection.sync();
//
//        commands.set("foo", "bar");
//        String result = commands.get("foo");
//        System.out.println(result); // >>> bar
//
//        connection.close();
//
//        client.shutdown();
//    }
//
//    public void update() {
//        Bucket bucket = new Bucket();
//
//        LocalDate currentDate = LocalDate.now();
//        Date d1 = new Date();
//        updateDate();
////        refillCount = floor((now() - bucket.lastUpdate) / bucket.refillTime);
//
//        System.out.println("Current Date: " + d1);
//
//    }
//
//    public void updateDate() {
//        // Example: Convert current date to start of the day
//        Date currentDate = new Date();
//
//        // Convert Date to LocalDateTime
//        LocalDateTime localDateTime = currentDate.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//
//        // Get the start of the day
//        LocalDateTime startOfDay = localDateTime.toLocalDate().atStartOfDay();
//
//        // Convert back to Date if needed
//        Date flooredDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
//
//        System.out.println("Original Date: " + currentDate);
//        System.out.println("Floored Date (Start of Day): " + flooredDate);
//    }
//    }
//
//

package com.pramod.ratelimiterusingredis.Controller;

import lombok.Data;

import java.io.Serializable;

@Data

public class Bucket  implements Serializable {


    /** a unique byte string that identifies the bucket   */
    private String key;

    /**the maximum number of tokens the bucket can hold*/
    private int maxAmount;

    /** the amount of time between refills  */
    private int refillTime;

    /** the number of tokens that are added to the bucket during a refill  */
    private int refillAmount;
    
    /** the current number of tokens in the bucket  */
    private int value;

    /**  the last time the bucket was updated       */
    private long lastUpdate;



}

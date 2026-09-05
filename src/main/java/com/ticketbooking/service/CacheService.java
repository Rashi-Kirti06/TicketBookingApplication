package com.ticketbooking.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CacheService {
    private final StringRedisTemplate redis;
    public CacheService(StringRedisTemplate redis){ this.redis = redis; }
    public void lockSeat( Long showId, String seat){
        redis.opsForValue().set("seat:" + showId + ":" + seat, "LOCKED",
                Duration.ofMinutes(5));
    }
    public boolean isSeatLocked(Long showId, String seat){
        return Boolean.TRUE.equals(redis.hasKey("seat:" + showId + ":" + seat));
    }
    public void releaseSeat(Long showId, String seat){
        redis.delete("seat:" + showId + ":" + seat);
    }
}


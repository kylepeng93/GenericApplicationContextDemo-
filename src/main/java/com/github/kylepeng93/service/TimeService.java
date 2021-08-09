package com.github.kylepeng93.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-07-23 下午10:00
 */
@Service
public class TimeService {
    public Instant getNow() {
        return Instant.now();
    }
}

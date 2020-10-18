package com.wl.gateway;


import lombok.Data;

import java.time.LocalTime;

/**
 * @Author zeng
 * @Date 2020/10/9 11:02
 * @Description
 * @Version 1.0
 */
@Data
public class TimeBetweenConfig {
    private LocalTime start;
    private LocalTime end;
}

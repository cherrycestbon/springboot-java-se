package com.example.demo.time;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class LocalDateTimeTest {
    @Test
    void getDayStartTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime dayStart = getDayStart(localDateTime);
        System.out.println("dayStart = " + dayStart);
        String dayStartFormat = dayStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("dayStartFormat = " + dayStartFormat);
    }
    /**
     * 获取传入时间的凌晨 00:00:00
     */
    public static LocalDateTime getDayStart(LocalDateTime paramTime) {
        if (null == paramTime) {
            return LocalDateTime.MIN;
        } else {
            return LocalDateTime.of(paramTime.toLocalDate(), LocalTime.MIN);
        }
    }
    @Test
    void getDayEndTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime dayEnd = getDayEnd(localDateTime);
        System.out.println("dayEnd = " + dayEnd);
        String dayEndFormat = dayEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("dayEndFormat = " + dayEndFormat);
    }
    /**
     * 获取传入时间当天最大的时间 23:59:59
     */
    public static LocalDateTime getDayEnd(LocalDateTime paramTime) {
        if (null == paramTime) {
            return LocalDateTime.MAX;
        } else {
            return LocalDateTime.of(paramTime.toLocalDate(), LocalTime.MAX);
        }
    }
    @Test
    void minusPlusTest() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间: " + fmt.format(LocalDateTime.now()));
        LocalDateTime time = LocalDateTime.now().minusMinutes(1L);
        System.out.println("获取上一分钟: " + fmt.format(time));
        LocalDateTime nextMin = LocalDateTime.now().plusMinutes(1L);
        System.out.println("获取下一分钟: " + fmt.format(nextMin));
    }

    @Test
    void localDateTest() {
        LocalDate localDate = LocalDate.now();
        //输出：localDate = 2022-10-26
        System.out.println("localDate = " + localDate);
    }

    @Test
    void clockTest() {
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());
    }
}

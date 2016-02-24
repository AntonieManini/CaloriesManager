package com.anton.project.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Anton on 19.02.16.
 */
public class TimeUtil {
    public static final LocalDate MIN_DATE = LocalDate.of(0, 1, 1);
    public static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static boolean isBetween(LocalDateTime ldt, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ldt.compareTo(startDateTime) >= 0 && ldt.compareTo(endDateTime) <= 0;
    }

    public static LocalDate parseLocalDate(String str, LocalDate def) {
        return StringUtils.isEmpty(str) ? def : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str, LocalTime def) {
        return StringUtils.isEmpty(str) ? def : LocalTime.parse(str);
    }

}

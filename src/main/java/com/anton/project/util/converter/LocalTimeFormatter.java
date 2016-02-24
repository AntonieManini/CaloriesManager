package com.anton.project.util.converter;

import com.anton.project.util.TimeUtil;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Anton on 23.02.16.
 */
public class LocalTimeFormatter implements Formatter<LocalTime> {

    @Override
    public LocalTime parse(String text, Locale locale) throws ParseException {
        return TimeUtil.parseLocalTime(text, null);
    }

    @Override
    public String print(LocalTime lt, Locale locale) {
        return lt.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}

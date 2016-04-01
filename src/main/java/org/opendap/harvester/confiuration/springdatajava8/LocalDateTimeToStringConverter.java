package org.opendap.harvester.confiuration.springdatajava8;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.toString();
    }
}
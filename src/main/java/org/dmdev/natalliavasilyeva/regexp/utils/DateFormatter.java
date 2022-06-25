package org.dmdev.natalliavasilyeva.regexp.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static String formatDate(LocalDateTime date) {

        return date.format(FORMATTER);
    }

    private DateFormatter() {
    }

}
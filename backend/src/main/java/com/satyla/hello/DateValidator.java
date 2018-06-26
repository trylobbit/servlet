package com.satyla.hello;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateValidator {

    private DateValidator() {

    }

    public static boolean isDateCorrect(String date) {
        if (date.matches("([1-2][0-9][0-9][0-9])-([0-9]{2})-([0-9]{2})")) {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return parsedDate.isBefore((LocalDate.now()));
        } else
            return false;
    }
}

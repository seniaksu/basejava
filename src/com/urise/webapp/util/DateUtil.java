package com.urise.webapp.util;

import java.time.Month;
import java.time.YearMonth;

public class DateUtil {
    public static final YearMonth NOW = YearMonth.of(3000, 1);

    public static YearMonth of(int year, Month month) {
        return YearMonth.of(year, month);
    }
}

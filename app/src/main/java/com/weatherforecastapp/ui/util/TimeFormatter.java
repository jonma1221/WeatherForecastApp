package com.weatherforecastapp.ui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeFormatter {
    public static String getTimeinHours(int currentTimeUnix){
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        Date date = new Date(currentTimeUnix * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("h a", Locale.getDefault());
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }

    public static String getTimeInDays(int currentTimeUnix){
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        Date date = new Date(currentTimeUnix * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.getDefault());
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }
}

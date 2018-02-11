package com.dy.inv.utils;

import com.dy.inv.model.DayVal;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getPreviousDay(String dateString) throws ParseException {
        DateTime prev = getDateFromString(dateString).minus(1);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yy");
        String str = prev.toString(fmt);
        return str;
    }

    public static DateTime getDateFromString(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        Date date = formatter.parse(dateString);
        return new DateTime(date);
    }
}

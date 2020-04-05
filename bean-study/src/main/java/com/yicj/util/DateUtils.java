package com.yicj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date parseDate(String source, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(source);
    }
}

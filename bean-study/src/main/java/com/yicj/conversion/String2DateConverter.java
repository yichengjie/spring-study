package com.yicj.conversion;

import com.yicj.util.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try {
            return DateUtils.parseDate(source,"yyyy-MM-dd HH:mm:ss") ;
        }catch (ParseException e){
            return null ;
        }
    }
}

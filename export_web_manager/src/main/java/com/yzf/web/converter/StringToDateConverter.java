package com.yzf.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型转换器
 * 泛型一：源类型
 * 泛型二：目录类型
 */
public class StringToDateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
package io.github.buhuiwandexiaobai.workflow.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaobin
 * @date 2021/7/13 00:36
 */
public class DataTimeUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDataStr(long timeStamp) {
        return DATE_FORMAT.format(new Date(timeStamp));
    }
}

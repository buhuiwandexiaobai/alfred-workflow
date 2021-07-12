package io.github.buhuiwandexiaobai.workflow.utils;

/**
 * @author zhaobin
 * @date 2021/7/13 01:29
 */
public class NumberUtils {
    public static long toLong(String str, long defaultVal) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public static int toInt(String str, int defaultVal) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defaultVal;
        }
    }
}

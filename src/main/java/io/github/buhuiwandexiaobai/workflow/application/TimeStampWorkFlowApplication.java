package io.github.buhuiwandexiaobai.workflow.application;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.buhuiwandexiaobai.workflow.model.ResultItem;
import io.github.buhuiwandexiaobai.workflow.model.WorkFlow;

/**
 * @author zhaobin
 * @date 2021/7/12 21:55
 */
public class TimeStampWorkFlowApplication {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        long timeStamp = getTimeStamp(args);
        Date date = new Date(timeStamp);
        ResultItem item = ResultItem.ResultItemBuilder.aResultItem()
                .setUid("0")
                .setTitle(DATE_FORMAT.format(date))
                .setSubtitle("timeStamp by buhuiwandexiaobai")
                .setValid(false)
                .build();
        WorkFlow workFlow = new WorkFlow();
        workFlow.addItem(item);
        System.out.println(workFlow);
    }

    private static long getTimeStamp(String[] args) {
        if (args == null || args.length == 0) {
            return System.currentTimeMillis();
        }
        try {
            return Long.parseLong(args[0]);
        } catch (Exception e) {
            return System.currentTimeMillis();
        }
    }
}

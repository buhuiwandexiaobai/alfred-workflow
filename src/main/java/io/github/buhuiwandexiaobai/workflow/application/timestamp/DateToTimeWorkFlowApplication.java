package io.github.buhuiwandexiaobai.workflow.application.timestamp;

import static io.github.buhuiwandexiaobai.workflow.utils.NumberUtils.toInt;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import io.github.buhuiwandexiaobai.workflow.application.AbstractWorkFlowApplication;
import io.github.buhuiwandexiaobai.workflow.model.ResultItem;
import io.github.buhuiwandexiaobai.workflow.model.ResultItem.ResultItemBuilder;

/**
 * @author zhaobin
 * @date 2021/7/13 00:53
 */
public class DateToTimeWorkFlowApplication extends AbstractWorkFlowApplication {
    private static final String UID = "0";
    private static final String SUBTITLE = "timestamp by buhuiwandexiaobai";

    public static void main(String[] args) {
        new DateToTimeWorkFlowApplication().run(args);
    }

    @Override
    protected List<ResultItem> getAllItems(String[] args) {
        ResultItem resultItem = ResultItemBuilder.aResultItem()
                .setIcon("icon_" + UID + ".png")
                .setUid(UID)
                .setSubtitle(SUBTITLE)
                .setTitle(getTimeStamp(args))
                .setArg(getTimeStamp(args))
                .setValid(false)
                .build();
        return Collections.singletonList(resultItem);
    }

    /**
     * convert to timestamp
     *
     * @param args like 2021-07-19 16:30:30:000
     */
    private String getTimeStamp(String[] args) {
        // 2021-07-19 16:30:30:000
        try {
            String[] strs1 = args[0].split("-");
            String[] strs2 = args[1].split(":");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, getNumber(0, strs1));
            calendar.set(Calendar.MONTH, getNumber(1, strs1) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, getNumber(2, strs1));
            calendar.set(Calendar.HOUR_OF_DAY, getNumber(0, strs2));
            calendar.set(Calendar.MINUTE, getNumber(1, strs2));
            calendar.set(Calendar.SECOND, getNumber(2, strs2));
            calendar.set(Calendar.MILLISECOND, getNumber(3, strs2));
            return String.valueOf(calendar.getTimeInMillis());
        } catch (Exception e) {
            return String.valueOf(System.currentTimeMillis());
        }
    }

    private int getNumber(int i, String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        try {
            return toInt(strs[i], 0);
        } catch (Exception e) {
            return 0;
        }
    }
}

package io.github.buhuiwandexiaobai.workflow.application.timestamp;

import static io.github.buhuiwandexiaobai.workflow.constant.AlfredWorkConstants.SUBTITLE;
import static io.github.buhuiwandexiaobai.workflow.utils.NumberUtils.toLong;

import java.util.Collections;
import java.util.List;

import io.github.buhuiwandexiaobai.workflow.application.AbstractWorkFlowApplication;
import io.github.buhuiwandexiaobai.workflow.model.ResultItem;
import io.github.buhuiwandexiaobai.workflow.model.ResultItem.ResultItemBuilder;
import io.github.buhuiwandexiaobai.workflow.utils.DataTimeUtils;

/**
 * @author zhaobin
 * @date 2021/7/12 21:55
 */
public class TimeToDateWorkFlowApplication extends AbstractWorkFlowApplication {
    private static final String UID = "0";

    public static void main(String[] args) {
        new TimeToDateWorkFlowApplication().run(args);
    }

    @Override
    protected List<ResultItem> getAllItems(String[] args) {
        ResultItem resultItem = ResultItemBuilder.aResultItem()
                .setIcon("icon_" + UID + ".png")
                .setUid(UID)
                .setSubtitle(SUBTITLE)
                .setTitle(DataTimeUtils.getDataStr(getTimeStamp(args)))
                .setValid(false)
                .setArg(DataTimeUtils.getDataStr(getTimeStamp(args)))
                .build();
        return Collections.singletonList(resultItem);
    }

    private static long getTimeStamp(String[] args) {
        if (args == null || args.length == 0) {
            return System.currentTimeMillis();
        }
        return toLong(args[0], System.currentTimeMillis());
    }
}

package io.github.buhuiwandexiaobai.workflow.application;

import java.util.Collections;
import java.util.List;

import io.github.buhuiwandexiaobai.workflow.model.ResultItem;

/**
 * @author zhaobin
 * @date 2021/7/12 21:52
 */
public class AlfredExampleWorkFlowApplication extends AbstractWorkFlowApplication{
    /**
     * just for example
     */
    public static void main(String[] args) {
        new AlfredExampleWorkFlowApplication().run(args);
    }

    @Override
    protected List<ResultItem> getAllItems(String[] args) {
        ResultItem item = ResultItem.ResultItemBuilder.aResultItem()
                .setArg("arg")
                .setIcon("icon")
                .setUid("uid")
                .setTitle("title")
                .setSubtitle("subtitle")
                .setValid(false)
                .build();
        return Collections.singletonList(item);
    }
}

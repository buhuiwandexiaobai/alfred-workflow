package io.github.buhuiwandexiaobai.workflow.application;

import io.github.buhuiwandexiaobai.workflow.model.ResultItem;
import io.github.buhuiwandexiaobai.workflow.model.WorkFlow;

/**
 * @author zhaobin
 * @date 2021/7/12 21:52
 */
public class AlfredWorkFlowApplication {
    /**
     * just for example
      * @param args
     */
    public static void main(String[] args) {
        ResultItem item = ResultItem.ResultItemBuilder.aResultItem()
                .setArg("arg")
                .setIcon("icon")
                .setUid("uid")
                .setTitle("title")
                .setSubtitle("subtitle")
                .setValid(false)
                .build();
        WorkFlow workFlow = new WorkFlow();
        workFlow.addItem(item);
        workFlow.addItem(item);
        System.out.println(workFlow);
    }
}

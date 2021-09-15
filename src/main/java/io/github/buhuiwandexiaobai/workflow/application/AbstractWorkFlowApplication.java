package io.github.buhuiwandexiaobai.workflow.application;

import java.util.List;

import io.github.buhuiwandexiaobai.workflow.model.ResultItem;
import io.github.buhuiwandexiaobai.workflow.model.WorkFlow;

/**
 * @author zhaobin
 * @date 2021/7/13 00:30
 */
public abstract class AbstractWorkFlowApplication {


    /**
     * see example at io.github.buhuiwandexiaobai.workflow.application.AbstractWorkFlowApplication
     *
     * @param args alfred输入参数
     */
    public void run(String[] args) {
        WorkFlow workFlow = new WorkFlow();
        workFlow.addAllItems(getAllItems(args));
        System.out.println(workFlow);
    }

    /**
     * alfred 结果条目别表
     */
    protected abstract List<ResultItem> getAllItems(String[] args);
}

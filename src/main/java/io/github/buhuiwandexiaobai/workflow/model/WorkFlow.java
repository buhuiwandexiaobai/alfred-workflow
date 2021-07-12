package io.github.buhuiwandexiaobai.workflow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaobin
 * @date 2021/7/12 21:52
 */
public class WorkFlow {
    private List<ResultItem> items;

    public WorkFlow() {
        items = new ArrayList<>();
    }

    public void addItem(ResultItem item) {
        items.add(item);
    }

    public void addAllItems(List<ResultItem> items) {
        this.items.addAll(items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        items.stream()
                .map(ResultItem::toString)
                .forEach(itemContent -> sb.append(itemContent + "\n") );
        return "<items>\n"
                + sb.toString()
                +"</items>";
    }
}

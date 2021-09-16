package io.github.buhuiwandexiaobai.workflow.application.ip;

import static io.github.buhuiwandexiaobai.workflow.constant.AlfredWorkConstants.SUBTITLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import io.github.buhuiwandexiaobai.workflow.application.AbstractWorkFlowApplication;
import io.github.buhuiwandexiaobai.workflow.model.ResultItem;

/**
 * @author zhaobin
 * @date 2021/9/16 08:22
 */
public class IpAddressWorkFlowApplication extends AbstractWorkFlowApplication {

    public static void main(String[] args) {
        new IpAddressWorkFlowApplication().run(args);
    }

    @Override
    protected List<ResultItem> getAllItems(String[] args) {
        return getIpAddress().stream()
                .map(IpAddressWorkFlowApplication::buildItem)
                .collect(Collectors.toList());
    }

    private static ResultItem buildItem(String ip) {
        return ResultItem.ResultItemBuilder.aResultItem()
                .setIcon("icon.png")
                .setArg(ip)
                .setUid(UUID.randomUUID().toString())
                .setSubtitle(SUBTITLE)
                .setTitle(ip)
                .setValid(false)
                .build();
    }

    public List<String> getIpAddress() {
        try {
            Process process = Runtime.getRuntime().exec("ifconfig");
            return readLines(process.getInputStream()).stream()
                    .filter(line -> line.contains("inet"))
                    .filter(line -> line.contains("broadcast"))
                    .map(IpAddressWorkFlowApplication::parseIpAddress)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static String parseIpAddress(String line) {
        String[] strs = line.split(" ");
        if (strs.length < 2) {
            return StringUtils.EMPTY;
        }
        return strs[1];
    }

    private List<String> readLines(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}

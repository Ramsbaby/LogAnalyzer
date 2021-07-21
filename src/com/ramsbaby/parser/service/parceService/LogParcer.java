package com.ramsbaby.parser.service.parceService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 1:53
 */
@NoArgsConstructor
public class LogParcer<K, V> implements Parcer<K, V> {
    @Override
    public Map<K, List<V>> parce(String log) throws MalformedURLException, ParseException {
        Map<K, List<V>> readLogMap = new HashMap<>();

        String[] logLine = log.split("\n");

        for (String s : logLine) {
            LogModel eachLog = LogModel.of(s.replaceAll("\\[", "").split("]"));
            List<V> statusCodeList = readLogMap.getOrDefault(eachLog.getStatus(), new ArrayList<>());
            statusCodeList.add((V) eachLog);
            readLogMap.put((K) eachLog.getStatus(), statusCodeList);
        }

        return readLogMap;
    }
}

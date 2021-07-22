package com.ramsbaby.parser.utils.parse;

import com.ramsbaby.parser.model.LogModel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : RAMSBABY
 * @name : LogParser.java
 * @date : 2021-07-21 오전 1:53
 * 읽어들인 로그파일을 MAP형태로 변환
 **/
@NoArgsConstructor
public class LogParser<K, V> implements Parser<K, V> {
    @Override
    public Map<K, List<V>> parse(String log) throws MalformedURLException, ParseException {
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

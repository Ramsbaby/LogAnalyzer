package com.ramsbaby.parser.service.statisService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LogStatistic implements Statistic {
    @Override
    public int getMaxApiKey(Map<StatusCode, List<LogModel>> logMaps) {

        HashMap<String, Integer> maxCnt = new HashMap<>();
        logMaps.get(StatusCode.SUCCESS).stream().forEach(item -> {
            String apikey = item.getUrl().getApiKey();
            maxCnt.getOrDefault(item.getUrl().getApiKey(), 0);
            maxCnt.put(apikey, maxCnt.get(apikey).intValue()+1);
        });
//        logMaps.get(StatusCode.SUCCESS).value().stream().map(item -> {
//            String apikey = item.getUrl().getApiKey();
//            maxCnt.getOrDefault(item.getUrl().getApiKey(), 0);
//            maxCnt.put(apikey, maxCnt.get(apikey).intValue()+1);
//            return null;
//        });


        return 0;
    }
}

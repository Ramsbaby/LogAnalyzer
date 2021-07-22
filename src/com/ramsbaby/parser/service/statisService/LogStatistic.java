package com.ramsbaby.parser.service.statisService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : RAMSBABY
 * @name : LogStatistic.java
 * @date : 2021-07-22 오후 1:49
 * 통계데이터 산출 서비스
 **/
public class LogStatistic implements Statistic {
    private final int RANK_NUMBER = 3;

    // Comparator 정의
    Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();

    /**
     * 최다호출된 apikey를 찾는다.
     *
     * @param logMaps 로그파일 데이터
     * @return String 최다호출APIKEY
     */
    @Override
    public String getMaxApiKey(Map<StatusCode, List<LogModel>> logMaps) {
        HashMap<String, Integer> successApikeyMap = new HashMap<>();

        logMaps.get(StatusCode.SUCCESS).forEach(item -> {
            String apikey = item.getUrl().getApiKey();
            successApikeyMap.put(apikey, successApikeyMap.getOrDefault(item.getUrl().getApiKey(), 0) + 1);
        });

        Map.Entry<String, Integer> maxEntry = Collections.max(successApikeyMap.entrySet(), comparator);

        return maxEntry.getKey();
    }

    /**
     * 최다 호출 상위 3개의 serviceId와 갯수를 센다.
     *
     * @param logMaps 로그파일 데이터
     * @return Map<String, Integer> 최다 호출 상위 3개의 serviceId와 갯수
     */
    @Override
    public Map<String, Integer> getTop3ServiceIdAndCnt(Map<StatusCode, List<LogModel>> logMaps) {
        HashMap<String, Integer> successServiceIdMap = new HashMap<>();
        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();

        logMaps.get(StatusCode.SUCCESS).forEach(item -> {
            String serviceId = item.getUrl().getServiceID();
            successServiceIdMap.put(serviceId, successServiceIdMap.getOrDefault(item.getUrl().getServiceID(), 0) + 1);
        });

        List<Map.Entry<String, Integer>> listKeySet = new ArrayList<>(successServiceIdMap.entrySet());

        listKeySet = listKeySet.stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());

        listKeySet.stream().limit(RANK_NUMBER).forEach(item -> resultMap.put(item.getKey(), item.getValue()));

        return resultMap;
    }

    /**
     * 웹 브라우저별 비율 계산
     *
     * @param logMaps 로그파일 데이터
     * @return Map<String, Double> 웹 브라우저별 비율
     */
    @Override
    public Map<String, Double> getRateWebBrowser(Map<StatusCode, List<LogModel>> logMaps) {
        HashMap<String, Integer> successWebBrowserMap = new HashMap<>();
        Map<String, Double> resultMap = new LinkedHashMap<>();
        int successLogSize = logMaps.get(StatusCode.SUCCESS).size();

        logMaps.get(StatusCode.SUCCESS).forEach(item -> {
            String webBrowser = item.getWebBrower().toString();
            successWebBrowserMap.put(webBrowser, successWebBrowserMap.getOrDefault(item.getWebBrower().toString(), 0) + 1);
        });

        List<Map.Entry<String, Integer>> listKeySet = new ArrayList<>(successWebBrowserMap.entrySet());

        listKeySet = listKeySet.stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());

        listKeySet.forEach(item -> resultMap.put(item.getKey(), (double) item.getValue() / (double) successLogSize * 100));

        return resultMap;
    }
}

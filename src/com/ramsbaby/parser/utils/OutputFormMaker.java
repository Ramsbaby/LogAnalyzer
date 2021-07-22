package com.ramsbaby.parser.utils;

import java.util.Map;

/**
 * @author : RAMSBABY
 * @name : OutputFormMaker.java
 * @date : 2021-07-22 오후 3:46
 **/
public class OutputFormMaker implements FormMaker {

    /**
     * 통계데이터들을 정해진 출력형식으로 변경
     * @param maxCalledApiKey
     * @param top3ServiceIdMap
     * @param rateWebBrowserMap
     * @return
     */
    @Override
    public String makeForm(String maxCalledApiKey, Map<String, Integer> top3ServiceIdMap, Map<String, Double> rateWebBrowserMap) {

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("최다호출 APIKEY\n" + maxCalledApiKey);
        sBuilder.append("\n\n");

        sBuilder.append("상위 3개의 API Service ID와 각각의 요청 수\n");
        top3ServiceIdMap.entrySet().stream().forEach(item ->
                sBuilder.append(item.getKey() + " : " + item.getValue() + "\n")
        );
        sBuilder.append("\n\n");

        sBuilder.append("웹브라우저별 사용 비율\n");
        rateWebBrowserMap.entrySet().stream().forEach(item ->
                sBuilder.append(item.getKey() + " : " + Math.round(item.getValue()) + "%" + "\n")
        );

        return sBuilder.toString();
    }
}

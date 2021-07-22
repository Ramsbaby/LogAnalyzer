package com.ramsbaby.parser.service.statisService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;

import java.util.List;
import java.util.Map;

 /**
  * @name : Statistic.java
  * @date : 2021-07-22 오후 3:59
  * @author : RAMSBABY
 **/
public interface Statistic {
    String getMaxApiKey(Map<StatusCode, List<LogModel>> logMaps);

    Map<String, Integer> getTop3ServiceIdAndCnt(Map<StatusCode, List<LogModel>> logMaps);

    Map<String, Double> getRateWebBrowser(Map<StatusCode, List<LogModel>> logMaps);
}

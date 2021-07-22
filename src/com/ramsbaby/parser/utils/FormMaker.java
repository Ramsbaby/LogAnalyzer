package com.ramsbaby.parser.utils;

import java.util.Map;

 /**
  * @name : FormMaker.java
  * @date : 2021-07-22 오후 3:58
  * @author : RAMSBABY
 **/
public interface FormMaker {
    String makeForm(String maxCalledApiKeyMap, Map<String, Integer> top3ServiceidMap, Map<String, Double> rateWebBrowserMap);
}

package com.ramsbaby.parser.utils.form;

import java.util.Map;

/**
 * @author : RAMSBABY
 * @name : FormMaker.java
 * @date : 2021-07-22 오후 3:58
 **/
public interface FormMaker {
    String makeForm(String maxCalledApiKeyMap, Map<String, Integer> top3ServiceidMap, Map<String, Double> rateWebBrowserMap);
}

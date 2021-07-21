package com.ramsbaby.parser.service.parceService;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 2:20
 */
public interface Parcer<K, V> {
    public Map<K, List<V>> parce(String log) throws MalformedURLException, ParseException;
}

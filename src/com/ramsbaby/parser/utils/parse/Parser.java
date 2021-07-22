package com.ramsbaby.parser.utils.parse;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author : RAMSBABY
 * @name : Parser.java
 * @date : 2021-07-21 오전 2:20
 **/
public interface Parser<K, V> {
    Map<K, List<V>> parse(String log) throws MalformedURLException, ParseException;
}

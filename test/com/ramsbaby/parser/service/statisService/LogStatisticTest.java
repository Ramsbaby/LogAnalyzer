package com.ramsbaby.parser.service.statisService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;
import com.ramsbaby.parser.utils.io.LogReader;
import com.ramsbaby.parser.utils.parse.LogParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : RAMSBABY
 * @date : 2021-07-23 오전 2:45
 */
class LogStatisticTest {
    private static Map<StatusCode, List<LogModel>> logMaps;

    @BeforeAll
    static void setUp() throws IOException, ParseException {
        //first given
        String str = new LogReader().readLog("");
        LogParser logParcer = new LogParser<StatusCode, List<LogModel>>();
        logMaps = logParcer.parse(str);
    }

    @Test
    void 최다호출apikey_성공()  {
        //given
        String maxCalledApikey = "e3ea";

        //when
        LogStatistic logStatistic = new LogStatistic();

        //then
        assertEquals(logStatistic.getMaxApiKey(logMaps), maxCalledApikey);
    }

    @Test
    void 최다호출상위3개의_serviceId와_갯수_성공() {
        //given
        Map<String, Integer> top3ServiceIdMap = new HashMap<>();
        top3ServiceIdMap.put("knowledge", 809);
        top3ServiceIdMap.put("news", 803);
        top3ServiceIdMap.put("blog", 799);

        //when
        LogStatistic logStatistic = new LogStatistic();

        //then
        assertEquals(logStatistic.getTop3ServiceIdAndCnt(logMaps), top3ServiceIdMap);
    }

    @Test
    void 웹브라우저별_비율_계산_성공() {
        //given
        Map<String, Double> rateWebBrowserMap = new HashMap<>();
        rateWebBrowserMap.put("IE", 85.31704234253212);
        rateWebBrowserMap.put("Firefox", 6.825363387402571);
        rateWebBrowserMap.put("Opera", 3.054560775226459);
        rateWebBrowserMap.put("Chrome", 2.8017695386559933);
        rateWebBrowserMap.put("Safari", 2.0012639561828522);

        //when
        LogStatistic logStatistic = new LogStatistic();

        //then
        assertEquals(logStatistic.getRateWebBrowser(logMaps), rateWebBrowserMap);
    }
}
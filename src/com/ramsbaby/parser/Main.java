package com.ramsbaby.parser;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;
import com.ramsbaby.parser.service.ioService.LogReader;
import com.ramsbaby.parser.service.ioService.LogWriter;
import com.ramsbaby.parser.service.parceService.LogParcer;
import com.ramsbaby.parser.service.statisService.LogStatistic;
import com.ramsbaby.parser.utils.OutputFormMaker;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author : RAMSBABY
 * @name : Main
 * @date : 2021-07-21 오전 1:45
 **/
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //파싱
        String str = new LogReader().readLog("");
        LogParcer logParcer = new LogParcer<StatusCode, List<LogModel>>();
        Map<StatusCode, List<LogModel>> logMaps = logParcer.parce(str);

        //통계 데이터 추려내기
        LogStatistic logStatistic = new LogStatistic();
        String maxCalledApiKey = logStatistic.getMaxApiKey(logMaps);
        Map<String, Integer> top3ServiceIdMap = logStatistic.getTop3ServiceIdAndCnt(logMaps);
        Map<String, Double> rateWebBrowserMap = logStatistic.getRateWebBrowser(logMaps);

        //출력 폼 만들기
        OutputFormMaker outputFormMaker = new OutputFormMaker();
        String outputStr = outputFormMaker.makeForm(maxCalledApiKey, top3ServiceIdMap, rateWebBrowserMap);

        //출력
        LogWriter logWriter = new LogWriter();
        logWriter.writeLog(outputStr);
    }

}

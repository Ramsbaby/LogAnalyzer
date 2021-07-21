package com.ramsbaby.parser;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;
import com.ramsbaby.parser.service.ioService.LogReader;
import com.ramsbaby.parser.service.ioService.LogWriter;
import com.ramsbaby.parser.service.parceService.LogParcer;
import com.ramsbaby.parser.service.statisService.LogStatistic;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @name : Main
 * @date : 2021-07-21 오전 1:45
 * @author : RAMSBABY
**/
public class Main {
    //1.로그파일을 읽어들임
    //2.데이터들을 가공
    //3.아웃풋 파일로 출력한다.
    public static void main(String[] args) throws IOException, ParseException {
        //파싱
        String str = new LogReader().readLog("");
        LogParcer logParcer = new LogParcer<StatusCode, List<LogModel>>();
        Map<StatusCode, List<LogModel>> logMaps = logParcer.parce(str);


        //가공
        LogStatistic logStatistic = new LogStatistic();
        logStatistic.getMaxApiKey(logMaps);


        //출력

//        return LogWriter.write();
    }

}

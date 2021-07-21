package com.ramsbaby.parser.service.ioService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 1:52
 * 로그를 읽어들임
 */
public class LogReader {
    private final static String INPUT_LOG = "input.log";

    public String readLog(String path) throws IOException {

        StringBuilder inputLogStr = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(new File(path + INPUT_LOG)));

        String logLine;
        while ((logLine = reader.readLine()) != null)
            inputLogStr.append(logLine + "\n");

        return inputLogStr.toString();

    }
}

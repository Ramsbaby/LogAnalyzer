package com.ramsbaby.parser.utils.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author : RAMSBABY
 * @name : LogWriter.java
 * @date : 2021-07-21 오전 1:52
 * 주어진 포맷으로 아웃풋파일을 생성
 **/

public class LogWriter {
    private final String OUTPUT_FILENAME = "output.log";

    /**
     * 가공된 데이터 기반으로 분석로그파일생성
     *
     * @param outputStr 가공된 데이터
     */
    public void writeLog(String outputStr) throws IOException {
        File file = new File(OUTPUT_FILENAME);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(outputStr);
        writer.close();
    }
}

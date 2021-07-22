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

    public void writeLog(String outputStr) {
        File file = new File(OUTPUT_FILENAME);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(outputStr);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

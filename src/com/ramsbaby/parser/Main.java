package com.ramsbaby.parser;

import com.ramsbaby.parser.service.ioService.LogReader;

import java.io.IOException;

/**
 * @name : Main
 * @date : 2021-07-21 오전 1:45
 * @author : RAMSBABY
**/
public class Main {
    //1.로그파일을 읽어들임
    //2.데이터들을 가공
    //3.아웃풋 파일로 출력한다.
    public static void main(String[] args) throws IOException {
        //파싱
        String str = new LogReader().readLog("");
        System.out.println(str);
        //가공

        //출력
    }

}

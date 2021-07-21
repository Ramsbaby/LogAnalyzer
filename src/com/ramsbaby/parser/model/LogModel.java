package com.ramsbaby.parser.model;

import com.ramsbaby.parser.common.type.ServiceId;
import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.common.type.WebBrowser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sun.rmi.runtime.Log;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 2:33
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogModel {
    private StatusCode status;
    private UrlModel url;
    private WebBrowser webBrower;
    private Date date;

    public static LogModel of(String[] eachLog) throws MalformedURLException, ParseException {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sDateFormat.parse(eachLog[3]);

        //apikey가 없거나 q가 포함되지 않은 queryParam일 경우 에러코드 10으로 변경
        StatusCode statusCode = StatusCode.valueOf(Integer.parseInt(eachLog[0]));
        UrlModel urlModel = UrlModel.create(eachLog[1]);

        return new LogModel(statusCode, urlModel, WebBrowser.valueOf(eachLog[2]), date);
    }

}

package com.ramsbaby.parser.model;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.common.type.WebBrowser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : RAMSBABY
 * @name : LogModel.java
 * @date : 2021-07-21 오전 2:33
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogModel {
    @NonNull
    private StatusCode status;
    @NonNull
    private UrlModel url;
    private WebBrowser webBrower;
    private Date date;

    public static LogModel of(String[] eachLog) throws MalformedURLException, ParseException {

        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sDateFormat.parse(eachLog[3]);

        StatusCode statusCode = StatusCode.valueOf(Integer.parseInt(eachLog[0]));
        UrlModel urlModel = UrlModel.create(eachLog[1]);

        assert statusCode != null;
        return new LogModel(statusCode, urlModel, WebBrowser.valueOf(eachLog[2]), date);
    }

}

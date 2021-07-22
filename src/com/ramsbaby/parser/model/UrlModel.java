package com.ramsbaby.parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

/**
 * @author : RAMSBABY
 * @name : UrlModel.java
 * @date : 2021-07-21 오전 2:33
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {
    private String urlBody;
    private String serviceID;
    private String apiKey;
    private String queryParam;

    /**
     * 입력받은 URL을 대상으로 정상URL여부 판단
     *
     * @param urlStr 로그의 URL원본
     * @return UrlModel
     */
    public static UrlModel create(String urlStr) throws MalformedURLException {
        String urlBody = null;
        String serviceID = null;
        String apiKey = null;
        String queryParam = null;

        URL url = new URL(urlStr);

        //urlBody
        urlBody = urlStr;

        //serviceID
        serviceID = url.getPath().split("/")[2];

        //serviceId 예외처리
        if (serviceID.contains("&") || serviceID.contains("=")) serviceID = null;

        //queryParam
        queryParam = Optional.ofNullable(url.getQuery()).orElse(null);

        if (queryParam != null) {
            if (url.getQuery().split("&")[0].split("=")[0].equals("apikey") == false) // apikey가 없는 경우
            {
            } else if (url.getQuery().split("&")[1].split("=")[0].equals("q") == false) {// apikey가 있고, 검색어(q)가 잘못된 경우
                //apiKey
                apiKey = url.getQuery().split("&")[0].split("=")[1];
                queryParam = null;
            } else {// 그 이외의 경우
                //apiKey
                apiKey = url.getQuery().split("&")[0].split("=")[1];
            }
        }

        return new UrlModel(urlBody, serviceID, apiKey, queryParam);
    }
}

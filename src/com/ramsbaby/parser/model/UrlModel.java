package com.ramsbaby.parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    private static final String API_KEY = "apikey";
    private static final String QUERY_PARAM = "queryParam";
    private String urlBody;
    private String serviceID;
    private String apiKey;
    private String queryParam;

    /**
     * 입력받은 URL을 대상으로 정상URL여부 판단(생성자+필터)
     *
     * @param urlStr 로그의 URL원본
     * @return UrlModel
     */
    public static UrlModel create(String urlStr) throws MalformedURLException {
        String urlBody = null;
        String serviceID = null;
        String queryParam = null;
        String apiKey = null;

        URL url = new URL(urlStr);

        //urlBody
        urlBody = urlStr;

        //serviceID
        serviceID = url.getPath().split("/")[2];

        //serviceId 예외처리
        if (serviceID.contains("&") || serviceID.contains("=")) {
            serviceID = null;
        }

        //queryParam
        queryParam = Optional.ofNullable(url.getQuery()).orElse(null);

        apiKey = validateQueryParam(queryParam, url).get(API_KEY);
        queryParam = validateQueryParam(queryParam, url).get(QUERY_PARAM);

        return new UrlModel(urlBody, serviceID, apiKey, queryParam);
    }

    /**
     * apikey와 queryParam 유효성체크
     *
     * @param queryParam url 객체의 queryParam
     * @param url        로그모델의 url 객체
     * @return 유효성체크 후 반환되는 apikey와 queryParam
     */
    public static Map<String, String> validateQueryParam(String queryParam, URL url) {
        Map<String, String> resultMap = new HashMap<>();
        String validApikey = null;
        String validQueryParam = null;

        //queryParam validatition
        if (queryParam != null) {//queryParam이 존재하면 apikey를 추출
            boolean isApikeyExist = url.getQuery().split("&")[0].split("=")[0].equals("apikey");

            if (isApikeyExist == true) {// apikey가  있는 경우 검색어(q)를 추출
                boolean isQParamExist = url.getQuery().split("&")[1].split("=")[0].equals("q");

                if (isQParamExist == false) {// apikey가 있고, 검색어(q)가 잘못된 경우
                    //apiKey
                    validApikey = url.getQuery().split("&")[0].split("=")[1];
                    validQueryParam = null;
                } else {// apikey와 검색어(q)가 정상인 경우
                    //apiKey
                    validApikey = url.getQuery().split("&")[0].split("=")[1];
                    validQueryParam = queryParam;
                }
            }
        }

        resultMap.put(API_KEY, validApikey);
        resultMap.put(QUERY_PARAM, validQueryParam);

        return resultMap;
    }
}

package com.ramsbaby.parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 2:33
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {
    private String urlBody;
    private String serviceID;
    private String apiKey;
    private String queryParam;

    public static UrlModel create(String urlStr) throws MalformedURLException {
        //http://apis.daum.net/search/book?apikey=anw1&q=daum
        String urlBody = null;
        String serviceID = null;
        String apiKey = null;
        String queryParam = null;

        URL url = new URL(urlStr);

        urlBody = urlStr;

        serviceID = url.getPath().split("/")[2];

        queryParam = Optional.ofNullable(url.getQuery()).orElseGet(()->null);

        if(queryParam == null){

        }
        else if(queryParam != null){
            if(url.getQuery().split("&")[0].split("=")[0].equals("apikey") == false) // apikey가 없는 경우
                apiKey = null;
//            else if(url.getQuery().split("&")[1].split("=")[0].equals("q") == false) // apikey는 있으나, 파라미터가 q가 아닌 경우
//                apiKey = null;
            else{
                apiKey = url.getQuery().split("&")[0].split("=")[1];
            }
        }

        return new UrlModel(urlBody, serviceID, apiKey, queryParam);
    }
}

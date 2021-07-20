package com.ramsbaby.parser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author RAMSBABY
 * @date 2021-07-21 오전 2:33
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {
    private String mainUrl;
    private String serviceID;
    private String apiKey;
    private String apiQuery;
}

package com.ramsbaby.parser.model;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.common.type.WebBrowser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}

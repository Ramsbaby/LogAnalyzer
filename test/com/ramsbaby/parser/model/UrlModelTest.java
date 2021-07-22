package com.ramsbaby.parser.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author : RAMSBABY
 * @date : 2021-07-23 오전 1:31
 */
class UrlModelTest {

    @BeforeEach
    void setUp() {
        //first given
    }

    @Test
    public void URL정상() throws Exception {
        //given
        String url = "http://apis.daum.net/search/knowledge?apikey=23jf&q=daum";
        String serviceId = "knowledge";
        String apikey = "23jf";
        String queryParam = "apikey=23jf&q=daum";

        //when
        UrlModel urlModel = UrlModel.create(url);

        //then
        assertEquals(urlModel.getUrlBody(), url);
        assertEquals(urlModel.getServiceID(), serviceId);
        assertEquals(urlModel.getApiKey(), apikey);
        assertEquals(urlModel.getQueryParam(), queryParam);
    }

    @Test
    public void serviceId_없음_비정상() throws Exception {
        //given
        String url = "http://apis.daum.net/search/apikey=23jf&q=daum";

        //when
        UrlModel urlModel = UrlModel.create(url);

        //then
        assertEquals(urlModel.getUrlBody(), url);
        assertNull(urlModel.getServiceID());
        assertNull(urlModel.getApiKey());
        assertNull(urlModel.getQueryParam());
    }

    @Test
    public void serviceId_있으나_apikey없음_비정상() throws Exception {
        //given
        String url = "http://apis.daum.net/search/knowledge?aaaapikey=23jf&q=daum";
        String serviceId = "knowledge";
        String queryParam = "aaaapikey=23jf&q=daum";

        //when
        UrlModel urlModel = UrlModel.create(url);

        //then
        assertEquals(urlModel.getUrlBody(), url);
        assertEquals(urlModel.getServiceID(), serviceId);
        assertNull(urlModel.getApiKey());
        assertEquals(urlModel.getQueryParam(), queryParam);
    }

    @Test
    public void serviceId_있으나_apikey있으나_검색어비정상_비정상() throws Exception {
        //given
        String url = "http://apis.daum.net/search/knowledge?apikey=23jf&qwer=daum";
        String serviceId = "knowledge";
        String apikey = "23jf";
        String queryParam = "apikey=23jf&qwer=daum";

        //when
        UrlModel urlModel = UrlModel.create(url);

        //then
        assertEquals(urlModel.getUrlBody(), url);
        assertEquals(urlModel.getServiceID(), serviceId);
        assertEquals(urlModel.getApiKey(), apikey);
        assertNull(urlModel.getQueryParam(), queryParam);
    }

}
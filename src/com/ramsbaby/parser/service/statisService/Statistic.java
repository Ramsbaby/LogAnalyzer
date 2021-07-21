package com.ramsbaby.parser.service.statisService;

import com.ramsbaby.parser.common.type.StatusCode;
import com.ramsbaby.parser.model.LogModel;

import java.util.List;
import java.util.Map;

public interface Statistic {
    public int getMaxApiKey(Map<StatusCode, List<LogModel>> logMaps);
}

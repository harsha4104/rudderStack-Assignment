package com.rudderstack.source.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.source.exception.RudderStackException;

import java.util.Map;

public interface ConfigDataService {

    public void validateAndSaveConfigData(String sourceName , Map<String, String> configDto) throws RudderStackException, JsonProcessingException;
}

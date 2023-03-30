package com.rudderstack.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.assignment.exception.RudderStackException;

import java.util.Map;

public interface ConfigDataService {

    public void validateAndSaveConfigData(String sourceName , Map<String, String> configDto) throws RudderStackException, JsonProcessingException;
}

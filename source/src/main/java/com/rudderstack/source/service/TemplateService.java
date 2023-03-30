package com.rudderstack.source.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.source.dto.FieldDto;
import com.rudderstack.source.dto.TemplateDto;
import com.rudderstack.source.exception.RudderStackException;

import java.util.Map;

public interface TemplateService {

    public void postTemplate(String sourceName, Map<String, FieldDto> fields) throws RudderStackException, JsonProcessingException;

    public TemplateDto getTemplate(String sourceName) throws RudderStackException, JsonProcessingException;
}

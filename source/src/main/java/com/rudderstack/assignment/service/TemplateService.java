package com.rudderstack.assignment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rudderstack.assignment.dto.FieldDto;
import com.rudderstack.assignment.dto.TemplateDto;
import com.rudderstack.assignment.exception.RudderStackException;

import java.util.Map;

public interface TemplateService {

    public void postTemplate(String sourceName, Map<String, FieldDto> fields) throws RudderStackException, JsonProcessingException;

    public TemplateDto getTemplate(String sourceName) throws RudderStackException, JsonProcessingException;
}

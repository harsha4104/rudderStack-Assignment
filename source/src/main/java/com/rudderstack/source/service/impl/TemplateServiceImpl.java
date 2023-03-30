package com.rudderstack.source.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudderstack.source.dao.SourceDao;
import com.rudderstack.source.dao.TemplateDao;
import com.rudderstack.source.dto.FieldDto;
import com.rudderstack.source.dto.TemplateDto;
import com.rudderstack.source.exception.RudderStackException;
import com.rudderstack.source.model.Source;
import com.rudderstack.source.model.Template;
import com.rudderstack.source.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private TemplateDao templateDao;

    @Override
    public void postTemplate(String sourceName, Map<String, FieldDto> fields) throws RudderStackException, JsonProcessingException {

      Source source = validateSource(sourceName);
      validateTemplate(source);

      Template template = new Template();
      template.setSource(source);
      ObjectMapper objectMapper= new ObjectMapper();
      template.setTemplateData(objectMapper.writeValueAsString(fields));

      templateDao.save(template);

    }

    @Override
    public TemplateDto getTemplate(String sourceName) throws RudderStackException, JsonProcessingException {
        Source source = validateSource(sourceName);
        Template template = templateDao.getTemplateBySourceId(source.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, FieldDto> map = objectMapper.readValue(template.getTemplateData(), Map.class);
        TemplateDto templateDto = new TemplateDto();
        templateDto.setType(sourceName);
        templateDto.setFields(map);
        return templateDto;
    }

    private Source validateSource(String name) throws RudderStackException {
        Source source = sourceDao.findByName(name);

        if(Objects.isNull(source)){
            throw new RudderStackException("4XX", "No source exist with given attribute");
        }

        return source;
    }

    private void validateTemplate(Source source) throws RudderStackException {
        Template template = templateDao.getTemplateBySourceId(source.getId());

        if(!Objects.isNull(template)){
            throw new RudderStackException("4XX", "Tempalte already exist with the source");
        }
    }

}

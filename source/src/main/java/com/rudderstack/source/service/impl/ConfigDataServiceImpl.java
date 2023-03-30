package com.rudderstack.source.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudderstack.source.dao.SourceConfigDataDao;
import com.rudderstack.source.dao.SourceDao;
import com.rudderstack.source.dao.TemplateDao;
import com.rudderstack.source.dto.FieldDto;
import com.rudderstack.source.exception.RudderStackException;
import com.rudderstack.source.model.Source;
import com.rudderstack.source.model.SourceConfigData;
import com.rudderstack.source.model.Template;
import com.rudderstack.source.service.ConfigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@Service
public class ConfigDataServiceImpl implements ConfigDataService {

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private SourceConfigDataDao sourceConfigDataDao;

    @Override
    public void validateAndSaveConfigData(String sourceName, Map<String, String> configDto) throws RudderStackException, JsonProcessingException {

        Source source = validateSource(sourceName);
        Template template = templateDao.getTemplateBySourceId(source.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, FieldDto> map = objectMapper.readValue(template.getTemplateData(), Map.class);

        for(String key: configDto.keySet()){
            validataData(configDto.get(key), objectMapper.convertValue(map.get(key), FieldDto.class));
        }

        SourceConfigData sourceConfigData = new SourceConfigData();
        sourceConfigData.setConfigData(objectMapper.writeValueAsString(configDto));
        sourceConfigData.setSource(source);
        sourceConfigDataDao.save(sourceConfigData);

    }

    private void validataData(String data, FieldDto fieldDto) throws RudderStackException {

        if(fieldDto.isRequired() && StringUtils.isEmpty(data)){
            throw new RudderStackException("4XX", "Required Field is Null");
        }

        if(!StringUtils.isEmpty(data) && !Objects.isNull(fieldDto.getRegex()) && !data.matches(fieldDto.getRegex())){
            throw new RudderStackException("4XX", fieldDto.getRegexErrorMessage());
        }
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

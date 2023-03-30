package com.rudderstack.source.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudderstack.source.dto.SourceDto;
import com.rudderstack.source.dto.TemplateDto;
import com.rudderstack.source.exception.RudderStackException;
import com.rudderstack.source.response.APIResponseGeneric;
import com.rudderstack.source.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping("v1/template")
    public APIResponseGeneric<String> postTemplate(@RequestBody String templateDto){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            TemplateDto dto = objectMapper.readValue(templateDto, TemplateDto.class);
            templateService.postTemplate(dto.getType(), dto.getFields());

            return new APIResponseGeneric();
        }
        catch(RudderStackException ex){
            return new APIResponseGeneric(ex.getStatus(), ex.getErrorMessage());
        }
        catch (Exception ex){
            return new APIResponseGeneric("5XX", ex.getMessage());
        }
    }

    @GetMapping("v1/template")
    public APIResponseGeneric<TemplateDto> getTemplateBySource(@RequestParam String sourceName) {
        try {
            return new APIResponseGeneric<TemplateDto>(templateService.getTemplate(sourceName));
        }
        catch(RudderStackException ex){
            return new APIResponseGeneric(ex.getStatus(), ex.getErrorMessage());
        } catch (Exception ex) {
            return new APIResponseGeneric("5XX", ex.getMessage());
        }

    }


}

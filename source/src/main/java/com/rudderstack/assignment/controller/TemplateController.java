package com.rudderstack.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rudderstack.assignment.dto.TemplateDto;
import com.rudderstack.assignment.exception.RudderStackException;
import com.rudderstack.assignment.response.APIResponseGeneric;
import com.rudderstack.assignment.service.TemplateService;
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

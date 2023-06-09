package com.rudderstack.assignment.controller;

import com.rudderstack.assignment.exception.RudderStackException;
import com.rudderstack.assignment.response.APIResponseGeneric;
import com.rudderstack.assignment.service.ConfigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigDataController {

    @Autowired
    private ConfigDataService configDataService;

    @PostMapping("v1/source/data")
    public APIResponseGeneric getTemplateBySource(@RequestParam String sourceName, @RequestBody Map<String, String> configDto) {
        try {
            configDataService.validateAndSaveConfigData(sourceName, configDto);
            return new APIResponseGeneric();
        }
        catch(RudderStackException ex){
            return new APIResponseGeneric(ex.getStatus(), ex.getErrorMessage());
        } catch (Exception ex) {
            return new APIResponseGeneric("5XX", ex.getMessage());
        }
    }
}

package com.rudderstack.assignment.controller;

import com.rudderstack.assignment.dto.SourceDto;
import com.rudderstack.assignment.exception.RudderStackException;
import com.rudderstack.assignment.model.Source;
import com.rudderstack.assignment.response.APIResponseGeneric;
import com.rudderstack.assignment.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @PostMapping("v1/source")
    public APIResponseGeneric addSource(@RequestBody SourceDto sourceDto) {
        try {
            sourceService.addSource(sourceDto.getName());
            return new APIResponseGeneric();
        }
        catch(RudderStackException ex){
            return new APIResponseGeneric(ex.getStatus(), ex.getErrorMessage());
        }

    }

    @GetMapping("v1/source/list")
    public APIResponseGeneric<List<SourceDto>> getSourceList() {
        try {
            List<Source> sources = sourceService.getAllSource();
            List<SourceDto> result = new ArrayList<>();
            for(Source source: sources){
                SourceDto sourceDto = new SourceDto();
                sourceDto.setName(source.getName());
                result.add(sourceDto);
            }
            return new APIResponseGeneric<List<SourceDto>>(result);
        }
        catch(RudderStackException ex){
            return new APIResponseGeneric(ex.getStatus(), ex.getErrorMessage());
        }

    }

}

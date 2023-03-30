package com.rudderstack.source.controller;

import com.rudderstack.source.dto.SourceDto;
import com.rudderstack.source.exception.RudderStackException;
import com.rudderstack.source.model.Source;
import com.rudderstack.source.response.APIResponseGeneric;
import com.rudderstack.source.service.SourceService;
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

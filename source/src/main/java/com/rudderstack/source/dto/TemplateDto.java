package com.rudderstack.source.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TemplateDto {

    private String type;

    private Map<String,FieldDto> fields;
}

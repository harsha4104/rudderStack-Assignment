package com.rudderstack.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TemplateDto {

    private String type;

    private Map<String,FieldDto> fields;
}

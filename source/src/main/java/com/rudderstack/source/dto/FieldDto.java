package com.rudderstack.source.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FieldDto {

    private String type;
    private String label;
    private String regexErrorMessage;
    private String placeholder;
    private String regex;
    private boolean required;
    private String value;
    private List<OptionDto> options;
}

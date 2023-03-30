package com.rudderstack.assignment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "source_config_data", schema = "rudderstack")
public class SourceConfigData {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Source source;

    @Column(name= "config_data", nullable = false)
    private String configData;
}

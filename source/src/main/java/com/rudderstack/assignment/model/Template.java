package com.rudderstack.source.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "template", schema = "rudderstack")
public class Template {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Source source;

    @Column(name = "template_data")
    private String templateData;

}

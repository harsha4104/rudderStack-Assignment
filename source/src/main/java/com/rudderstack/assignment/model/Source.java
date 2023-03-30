package com.rudderstack.assignment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "source", schema = "rudderstack")
public class Source {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

}

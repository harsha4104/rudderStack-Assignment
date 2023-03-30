package com.rudderstack.source.dao;

import com.rudderstack.source.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SourceDao extends JpaRepository<Source, Integer> {

    public Source findByName(String name);

    public List<Source> findAll();
}

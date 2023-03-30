package com.rudderstack.assignment.dao;

import com.rudderstack.assignment.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateDao extends JpaRepository<Template, Integer> {

    public Template getTemplateBySourceId(long sourceId);
}

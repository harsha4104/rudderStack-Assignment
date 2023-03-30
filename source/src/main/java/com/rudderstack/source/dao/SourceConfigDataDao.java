package com.rudderstack.source.dao;

import com.rudderstack.source.model.SourceConfigData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceConfigDataDao extends JpaRepository<SourceConfigData, Integer> {
}

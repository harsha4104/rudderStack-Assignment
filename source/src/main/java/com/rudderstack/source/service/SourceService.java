package com.rudderstack.source.service;

import com.rudderstack.source.exception.RudderStackException;
import com.rudderstack.source.model.Source;

import java.util.List;

public interface SourceService {

    public void addSource(String name) throws RudderStackException;


    public List<Source> getAllSource() throws RudderStackException;
}

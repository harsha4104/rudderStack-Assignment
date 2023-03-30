package com.rudderstack.assignment.service;

import com.rudderstack.assignment.exception.RudderStackException;
import com.rudderstack.assignment.model.Source;

import java.util.List;

public interface SourceService {

    public void addSource(String name) throws RudderStackException;


    public List<Source> getAllSource() throws RudderStackException;
}

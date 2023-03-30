package com.rudderstack.assignment.service.impl;

import com.rudderstack.assignment.dao.SourceDao;
import com.rudderstack.assignment.exception.RudderStackException;
import com.rudderstack.assignment.model.Source;
import com.rudderstack.assignment.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceDao sourceDao;

    @Override
    public void addSource(String name) throws RudderStackException {

        Source source = sourceDao.findByName(name);

        if(!Objects.isNull(source)){
            throw new RudderStackException("4XX", "Source is already present");
        }

        source = new Source();
        source.setName(name);
        sourceDao.save(source);

    }

    @Override
    public List<Source> getAllSource() throws RudderStackException {
        return sourceDao.findAll();
    }
}

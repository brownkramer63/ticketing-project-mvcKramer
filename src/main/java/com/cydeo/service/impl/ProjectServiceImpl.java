package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.CrudService;
import com.cydeo.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements CrudService {

    @Override
    public Object save(Object user) {
        return null;
    }

    @Override
    public Object findById(Object username) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void deleteById(Object username) {

    }

    @Override
    public void update(Object object) {

    }
}

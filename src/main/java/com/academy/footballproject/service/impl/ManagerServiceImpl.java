package com.academy.footballproject.service.impl;

import com.academy.footballproject.repository.ManagerRepository;
import com.academy.footballproject.service.ManagerService;
import org.apache.catalina.Manager;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager findByName(String name) {
        return null;
    }

    @Override
    public Set<Manager> findAll() {
        return null;
    }



    @Override
    public Manager save(Manager manager) {
        return null;
    }
}

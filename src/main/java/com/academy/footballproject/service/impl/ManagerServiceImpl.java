package com.academy.footballproject.service.impl;

import com.academy.footballproject.exception.DuplicateResourceException;
import com.academy.footballproject.model.Manager;
import com.academy.footballproject.repository.ManagerRepository;
import com.academy.footballproject.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public Set<Manager> findAll() {
        return new TreeSet<>(managerRepository.findAll());


    }

    @Override
    public Manager save(Manager manager) {
        try {
            return managerRepository.save(manager);
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateResourceException(String.format("Player with number %d already exists.",manager.getId()));
        }
    }
}

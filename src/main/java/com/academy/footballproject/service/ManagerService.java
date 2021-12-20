package com.academy.footballproject.service;

import com.academy.footballproject.model.Manager;

import java.util.Set;

public interface ManagerService {


    Set<Manager> findAll();

    Manager save (Manager manager);
}

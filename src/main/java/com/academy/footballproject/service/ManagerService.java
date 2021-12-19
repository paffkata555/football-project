package com.academy.footballproject.service;

import com.academy.footballproject.repository.ManagerRepository;
import org.apache.catalina.Manager;

import java.util.Set;

public interface ManagerService {

    Manager findByName(String name);

    Set<Manager> findAll();

    Manager save (Manager manager);
}

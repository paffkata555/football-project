package com.academy.footballproject.repository;

import com.academy.footballproject.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {


    @Override
    Optional<Manager> findById(Long id);

    Optional<Manager>findByName(String name);


}

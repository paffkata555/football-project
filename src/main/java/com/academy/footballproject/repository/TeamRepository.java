package com.academy.footballproject.repository;

import com.academy.footballproject.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository <Team,Long>{


    @Override
    Optional<Team> findById(Long id);

}

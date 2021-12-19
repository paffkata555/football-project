package com.academy.footballproject.repository;

import com.academy.footballproject.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Override
    Optional<Player> findById(Long id);

    Optional<Player> findByNumber(Integer number);
}

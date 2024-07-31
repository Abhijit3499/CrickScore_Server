package com.crkscore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crkscore.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {}

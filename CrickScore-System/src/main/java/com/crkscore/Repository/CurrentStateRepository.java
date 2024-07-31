package com.crkscore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crkscore.model.CurrentState;

public interface CurrentStateRepository extends JpaRepository<CurrentState, Long> {}

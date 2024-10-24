package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Fortune;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {

}

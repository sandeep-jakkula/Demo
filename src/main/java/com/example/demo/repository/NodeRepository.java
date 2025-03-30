package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
	// Custom query methods (if needed) can be defined here
}
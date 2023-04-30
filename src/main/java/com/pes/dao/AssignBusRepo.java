package com.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pes.entities.teacher_record;

public interface AssignBusRepo extends JpaRepository<teacher_record, Integer> {

}

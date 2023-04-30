package com.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pes.entities.pes_student_rem;

public interface StudentFeedbackRepo extends JpaRepository<pes_student_rem, Integer> {

}

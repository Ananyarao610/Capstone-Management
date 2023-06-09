package com.pes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pes.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

	@Query("select t from Teacher t")
	public List<Teacher> getAllTeacher();

}

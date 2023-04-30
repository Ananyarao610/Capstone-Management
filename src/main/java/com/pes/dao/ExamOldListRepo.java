package com.pes.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pes.entities.pes_ExamOldList;

public interface ExamOldListRepo extends JpaRepository<pes_ExamOldList, Integer> {

	@Query("select e from pes_ExamOldList e")
	public Page<pes_ExamOldList> getAllOldExamList(Pageable pageable);

}

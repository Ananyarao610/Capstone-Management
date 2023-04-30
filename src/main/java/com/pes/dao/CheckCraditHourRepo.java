package com.pes.dao;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_check;

public interface CheckCraditHourRepo extends JpaRepository<pes_check, Integer> {
	@Null
	@Query("select g from pes_check g where g.semester = :semester AND g.rollNo = :rollNo")
	public pes_check getAllGPARecord(@Param("semester") String semester, @Param("rollNo") String rollNo);

	@Modifying
	@Transactional
	@Query("update pes_check g set g.semesterCraditHour = :semesterCraditHour  WHERE g.rollNo = :rollNo AND g.semester = :semester")
	public int updateGPARecordCraditHour(@Param(value = "semesterCraditHour") float semesterCraditHour,
			@Param(value = "rollNo") String rollNo, @Param(value = "semester") String semester);
}

package com.pes.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_student_;

public interface StudentFeeRecordRepo extends JpaRepository<pes_student_, Integer> {

	@Query("select s from pes_student_ s where s.rollNo = :rollNo")
	public pes_student_ getAllStudentsByRollNo(@Param("rollNo") String rollNo);

	@Query("select SUM (totalFee) from pes_student_ s")
	public Integer getGrossIncome();

	@Query("select SUM (totalFee) from pes_student_ s where s.feeSumbmittedDate BETWEEN :startDate AND :endDate")
	public Integer getGrossIncomeByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

	@Query("select SUM (submittedFee) from pes_student_ s")
	public Integer getNetIncome();

	@Query("select s from pes_student_ s")
	public Page<pes_student_> getAllStudents(Pageable pageable);

}
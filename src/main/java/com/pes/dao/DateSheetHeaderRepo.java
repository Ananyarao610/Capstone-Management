package com.pes.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_DateSheetHeader;

public interface DateSheetHeaderRepo extends JpaRepository<pes_DateSheetHeader, Integer> {
	@Query("select d from pes_DateSheetHeader d")
	public List<pes_DateSheetHeader> getAllDateSheetHeader();

	@Modifying
	@Transactional
	@Query("update pes_DateSheetHeader d set"
			+ " d.dateSheetDate = :dateSheetDate,"
			+ " d.department = :department,"
			+ " d.dateSheetType = :dateSheetType,"
			+ " d.firstShiftTime = :firstShiftTime,"
			+ " d.secondShiftTime = :secondShiftTime")
	public int updateDateSheetHeader(@Param(value = "dateSheetDate") String dateSheetDate,
			@Param(value = "department") String department,
			@Param(value = "dateSheetType") String dateSheetType,
			@Param(value = "firstShiftTime") String firstShiftTime,
			@Param(value = "secondShiftTime") String secondShiftTime);
}

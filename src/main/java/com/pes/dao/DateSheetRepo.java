package com.pes.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_DateSheetRecords;

public interface DateSheetRepo extends JpaRepository<pes_DateSheetRecords, Integer> {
	@Query("select d from pes_DateSheetRecords d")
	public List<pes_DateSheetRecords> getAllDateSheetRecords();

	@Modifying
	@Transactional
	@Query("update pes_DateSheetRecords d set"
			+ " d.firstPaperNameOne = :firstPaperNameOne,"
			+ " d.firstPaperNameTwo = :firstPaperNameTwo,"
			+ " d.secondPaperNameOne = :secondPaperNameOne,"
			+ " d.secondPaperNameTwo = :secondPaperNameTwo,"
			+ " d.semester = :semester,"
			+ " d.date = :date"
			+ " where d.id= :id")
	public int updateDateSheetRecords(@Param(value = "id") int id,
			@Param(value = "firstPaperNameOne") String firstPaperNameOne,
			@Param(value = "firstPaperNameTwo") String firstPaperNameTwo,
			@Param(value = "secondPaperNameOne") String secondPaperNameOne,
			@Param(value = "secondPaperNameTwo") String secondPaperNameTwo,
			@Param(value = "semester") String semester,
			@Param(value = "date") String date);
}

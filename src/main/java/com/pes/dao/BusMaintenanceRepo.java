package com.pes.dao;

import java.sql.Date;

import javax.validation.constraints.Null;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_teacher;

public interface BusMaintenanceRepo extends JpaRepository<pes_teacher, Integer> {
	@Null
	@Query("select SUM (amount) from pes_teacher p")
	public Integer getAllBusMaintenace();

	@Null
	@Query("select SUM (amount) from pes_teacher p where p.date BETWEEN :startDate AND :endDate")
	public Integer getAllBusMaintenaceByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}

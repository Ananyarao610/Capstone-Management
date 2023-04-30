package com.pes.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.teach;

public interface BusRepo extends JpaRepository<teach, Integer> {
	@Query("select b from teach b where b.busId = :busId")
	public List<teach> getBusRecordById(@Param(value = "busId") int busId);

	@Null
	@Query("select SUM(busSeat) from teach")
	public Integer getTotalBusSeats();

	@Query("select b from teach b where b.busId = :busId")
	public teach getBusTotalSeatsById(@Param(value = "busId") int busId);

	@Modifying
	@Transactional
	@Query("update teach b set b.asignStatus = :asignStatus WHERE b.busId = :busId")
	public int updateBusStatusById(@Param(value = "busId") int busId, @Param(value = "asignStatus") String asignStatus);
}

package com.pes.dao;

import javax.validation.constraints.Null;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_book_meeting;

public interface SeatBookRepo extends JpaRepository<pes_book_meeting, Integer> {

	@Null
	@Query(value = "select  count(seatNo) from pes_book_meeting b where b.busId.busId = :busId")
	Integer getBusRecordById(@Param(value = "busId") int busId);

}

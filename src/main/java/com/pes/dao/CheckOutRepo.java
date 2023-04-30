package com.pes.dao;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_out;

public interface CheckOutRepo extends JpaRepository<pes_out, Integer> {

	@Modifying
	@Transactional
	@Query("update pes_out c set c.submitFee =:submitFee , c.checkOutDate = :checkOutDate WHERE c.id =:id")
	public int updateTransportFeeRecord(@Param(value = "id") int id, @Param(value = "checkOutDate") Date checkOutDate,
			@Param(value = "submitFee") float submitFee);

}

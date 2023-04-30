package com.pes.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.research_paper;

public interface BookRepo extends JpaRepository<research_paper, Integer> {

	@Query("select b from research_paper b order by b.id")
	public Page<research_paper> getAllBooks(Pageable pageable);

	@Query("select b from research_paper b where b.id = :id")
	public Page<research_paper> getBooksById(Pageable pageable, @Param(value = "id") int id);

	@Modifying
	@Transactional
	@Query("update research_paper g set g.availibile = :availibile WHERE g.id = :id")
	public int updateBookRecord(@Param(value = "availibile") String availibile, @Param(value = "id") int id);

	@Modifying
	@Transactional
	@Query("update research_paper g set g.quantity = :quantity WHERE g.id = :id")
	public int updateBookRecordOfQuantity(@Param(value = "quantity") int quantity, @Param(value = "id") int id);

	// SearchAlgorithm
	// @Query("SELECT * FROM ResultList WHERE rollNo LIKE :rollNo")
	public List<research_paper> findByTitleContaining(String title);

}

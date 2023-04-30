package com.pes.dao;

import java.sql.Date;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pes.entities.pes_details;

public interface ProductsRepo extends JpaRepository<pes_details, Integer> {

	@Query("select p from pes_details p where p.categoriesId.id = :categoriesId")
	public Page<pes_details> getAllProducts(Pageable pageable, @Param("categoriesId") int categoriesId);

	@Query("select SUM (productPrice) from pes_details p")
	public Integer getAllTotalProductsPrice();

	@Query("select SUM (productPrice) from pes_details p where p.date BETWEEN :startDate AND :endDate")
	public Integer getAllTotalProductsPriceByDate(@Param(value = "startDate") Date startDate,
			@Param(value = "endDate") Date endDate);

	@Modifying
	@Transactional
	@Query("update pes_details p set p.quantity = :quantity WHERE p.id = :id")
	public int updateProductCategoryId(@Param(value = "id") int id, @Param(value = "quantity") String quantity);

}

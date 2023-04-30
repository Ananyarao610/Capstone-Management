package com.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pes.entities.pes_show;

public interface CheckoutProductRepo extends JpaRepository<pes_show, Integer> {

}

package com.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pes.entities.pes_meet_stat;

public interface VehicleConditionRepo extends JpaRepository<pes_meet_stat, Integer> {

}

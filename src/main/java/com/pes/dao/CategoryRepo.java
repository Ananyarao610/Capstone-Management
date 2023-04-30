package com.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pes.entities.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {

}

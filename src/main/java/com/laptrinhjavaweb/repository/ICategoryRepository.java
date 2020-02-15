package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryDTO> {
	void insert(CategoryEntity entity);
	
}

 
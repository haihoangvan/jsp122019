package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.EntityManagerFactory;
import com.laptrinhjavaweb.repository.ICategoryRepository;

public class CategoryRepository extends SimpleJpaRepository<CategoryDTO> implements ICategoryRepository {

	@Override
	public void insert(CategoryEntity entity) {
		String sql = "insert into category(name, code) values(?,?)";
		this.insert(sql, entity.getName(), entity.getCode());
	}
}

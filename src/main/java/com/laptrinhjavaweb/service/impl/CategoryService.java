package com.laptrinhjavaweb.service.impl;

import java.util.List;

import com.laptrinhjavaweb.converter.CategoryCoverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.repository.ICategoryRepository;
import com.laptrinhjavaweb.repository.impl.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{

	private ICategoryRepository categoryRepository= new CategoryRepository();
	@SuppressWarnings("unused")
	private CategoryCoverter categoryCoverter = new CategoryCoverter();
	
	@Override
	public List<CategoryDTO> findAll() {
		/*
		 * // TODO Auto-generated method stub return categoryRepository.findAll();
		 */
		return null;
	}

	@Override
	public void insert(CategoryDTO dto) {
		categoryRepository.insert(categoryCoverter.convertDTOToEntity(dto));
	}

}

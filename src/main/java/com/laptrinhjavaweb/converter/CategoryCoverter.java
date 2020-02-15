package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

public class CategoryCoverter {
	
	private ModelMapper modelMapper = new ModelMapper();

	public CategoryDTO convertEntitytoDTO(CategoryEntity entity) {
		CategoryDTO categoryDTO = modelMapper.map(entity, CategoryDTO.class);
		return categoryDTO;
		
	}
	public CategoryEntity convertDTOToEntity(CategoryDTO dto) {
		CategoryEntity categoryEntity = modelMapper.map(dto, CategoryEntity.class);
		return categoryEntity;
		
	}
}
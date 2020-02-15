package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

public class NewCoverter {
	private ModelMapper modelMapper = new ModelMapper();

	public NewDTO convertEntitytoDTO(NewEntity entity) {
		NewDTO newDTO = modelMapper.map(entity, NewDTO.class);
		return newDTO;
		
	}
	public NewEntity convertDTOToEntity(NewDTO dto) {
		NewEntity newEntity = modelMapper.map(dto, NewEntity.class);
		return newEntity;
		
	}
}


	
	
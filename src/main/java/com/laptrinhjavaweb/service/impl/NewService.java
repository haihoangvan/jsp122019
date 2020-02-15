package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.NewCoverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.INewRepository;
import com.laptrinhjavaweb.repository.impl.NewRepository;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {

	private INewRepository newRepository = new NewRepository();
	private NewCoverter newConverter = new NewCoverter();

	@Override
	public List<NewDTO> findAll() {
		// java 7
		List<NewDTO> results = new ArrayList<NewDTO>();
		List<NewEntity> entities = newRepository.findAll();
		// convert data entity --> dto
		for (NewEntity item : entities) {
			NewDTO newDTO = newConverter.convertEntitytoDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public void insert(NewDTO dto) {
		newRepository.insert(newConverter.convertDTOToEntity(dto));
		
	}
}

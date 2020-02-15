package com.laptrinhjavaweb;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.NewService;

public class EstateApplication {
	public static void main(String[] args) {

		
		@SuppressWarnings("unused")
		ICategoryService categoryService = new CategoryService();
		//categoryService.findAll();
		/*CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setName("thể thao");
		categoryDTO.setCode("the-thao");
		categoryService.insert(categoryDTO);*/

		INewService newService = new NewService();
		//newService.findAll();
		NewDTO newDTO = new NewDTO();
		newDTO.setTitle("abc");
		newDTO.setCategoryId(1L);
		newDTO.setContent("abc");
		newService.insert(newDTO);
		
	}
}

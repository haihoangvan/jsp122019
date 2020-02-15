package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.INewRepository;

public class NewRepository extends SimpleJpaRepository<NewEntity> implements INewRepository {

	/*@Override
	public void insert(NewEntity entity) {
		String sql = "insert into news(title,content, categoryid) values(?,?,?)";
		this.insert(sql, entity.getTitle(),entity.getContent(), entity.getCategoryId());
	}*/
}

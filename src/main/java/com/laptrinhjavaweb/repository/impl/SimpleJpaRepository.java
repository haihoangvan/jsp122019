package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Field;
import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.EntityManagerFactory;
import com.laptrinhjavaweb.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {

	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String tableName = "";
		if (connection != null) {
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					Table table = zClass.getAnnotation(Table.class);
					tableName = table.name();
				}
				String sql = "select * from " + tableName + "";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				return resultSetMapper.mapRow(resultSet, zClass);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					return new ArrayList<>();
				}

			}
		
		}
		return new ArrayList<>();
	}

	@Override
	public void insert(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			int index=1;
			for (@SuppressWarnings("unused") Object object : objects) {
				statement.setObject(index, objects);
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}

	@Override
	public void insert(Object object) {
		String sql = createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			//convert object -- > object class
			Class<?> aClass = object.getClass();
			int index=1;
			for (java.lang.reflect.Field aField : aClass.getDeclaredFields()) {
				aField.setAccessible(true);
				statement.setObject(index, aField.get(object));
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException | IllegalAccessException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}

	private String createSQLInsert() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (java.lang.reflect.Field field: zClass.getDeclaredFields()) {
			if(fields.length() >1) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class))
			{
				Column column =field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		String sql = "INSERT INTO "+tableName+"("+fields.toString()+") VALUES("+params.toString()+")";
		return sql;
	}

}


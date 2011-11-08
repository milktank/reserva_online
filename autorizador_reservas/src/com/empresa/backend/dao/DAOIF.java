package com.empresa.backend.dao;

import java.util.List;

public interface DAOIF<T> {

	public List<T> getAll();
	
	public T searchOne(T model);
	
	public void insert(T obj);
	
}

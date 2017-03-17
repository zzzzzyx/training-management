package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.ClassChange;

public interface ClassChangeDao {

	public boolean save(ClassChange newClass);
	
	public List<ClassChange> getAll();

	public ClassChange getClassChangeById(long changeId);

	public void deleteClassChangeById(long changeId);
}

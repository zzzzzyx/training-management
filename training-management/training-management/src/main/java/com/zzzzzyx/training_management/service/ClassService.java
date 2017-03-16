package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.model.ClassChange;

public interface ClassService {

	public void openClass(ClassChange newClass, long institution_id);
	
	public List<ClassChange> getAllClassChange();
}

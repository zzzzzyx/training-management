package com.zzzzzyx.training_management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzzzzyx.training_management.dao.ClassChangeDao;
import com.zzzzzyx.training_management.model.ClassChange;
import com.zzzzzyx.training_management.service.ClassService;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassChangeDao classDao;
	
	@Override
	public void openClass(ClassChange newClass, long institution_id) {
		newClass.setChangeKind(ClassChange.ChangeKind_register);
		newClass.setInstitution_id(institution_id);
		newClass.setDescription("Institution " + institution_id + " apply for opening a new course.");
		classDao.save(newClass);
	}

	@Override
	public List<ClassChange> getAllClassChange() {
		return classDao.getAll();
	}

}

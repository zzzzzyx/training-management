package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.model.ClassChange;

@Repository
public class ClassChangeDao implements com.zzzzzyx.training_management.dao.ClassChangeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(ClassChange newClass) {
		sessionFactory.getCurrentSession().save(newClass);
		return true ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassChange> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(ClassChange.class).list();
	}
	
	

}

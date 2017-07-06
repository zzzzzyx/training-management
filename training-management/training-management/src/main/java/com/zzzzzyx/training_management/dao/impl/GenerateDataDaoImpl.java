package com.zzzzzyx.training_management.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.GenerateDataDao;
import com.zzzzzyx.training_management.model.globalData.ins.user.RegisterCourseNum;
import com.zzzzzyx.training_management.model.globalData.ins.user.RegisterStudentNum;
import com.zzzzzyx.training_management.model.globalData.manager.course.InsToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.KindToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.LengthToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.course.PriceToCourse;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncome;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeIncrease;
import com.zzzzzyx.training_management.model.globalData.manager.income.MonthIncomeRate;
import com.zzzzzyx.training_management.model.globalData.manager.ins.MarkToIns;
import com.zzzzzyx.training_management.model.globalData.manager.ins.StudentToIns;
import com.zzzzzyx.training_management.model.globalData.manager.user.AttendCourseLevel;
import com.zzzzzyx.training_management.model.globalData.manager.user.ComsumeLevel;
import com.zzzzzyx.training_management.model.globalData.manager.user.RegisterUserNum;
import com.zzzzzyx.training_management.model.globalData.manager.user.RegisterUserTotal;

@Repository
public class GenerateDataDaoImpl implements GenerateDataDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void generateData() {
		
//		List<RegisterUserNum> l = getRegisterUserNumList();
//		long result = 0;
//		for(RegisterUserNum n : l){
//			RegisterUserTotal r = new RegisterUserTotal();
//			r.setDay(n.getDay());
//			result += n.getNum();
//			r.setNum(result);
//			sessionFactory.getCurrentSession().save(r);
//		}
		
//		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		for(int i = 0 ; i < 200 ; i ++){
//			RegisterUserNum n = new RegisterUserNum();
//			n.setDay(c.getTime());
//			n.setNum(f(200 - i));
//			int day = c.get(Calendar.DATE);
//			c.set(Calendar.DATE, day - 1);
//			sessionFactory.getCurrentSession().save(n);
//		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterUserNum> getRegisterUserNumList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RegisterUserNum.class);
		criteria.addOrder(Order.asc("day"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterUserTotal> getRegisterUserTotalList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RegisterUserTotal.class);
		criteria.addOrder(Order.asc("day"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ComsumeLevel> getConsumeLevelList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ComsumeLevel.class);
		criteria.addOrder(Order.asc("month"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AttendCourseLevel> getAttendCourseLevelList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AttendCourseLevel.class);
		criteria.addOrder(Order.asc("month"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MonthIncome> getMonthIncomeList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MonthIncome.class);
		criteria.addOrder(Order.asc("month"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MonthIncomeRate> getMonthIncomeRateList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MonthIncomeRate.class);
		criteria.addOrder(Order.asc("month"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MonthIncomeIncrease> getMonthIncomeIncreaseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MonthIncomeIncrease.class);
		criteria.addOrder(Order.asc("month"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PriceToCourse> getPriceToCourseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PriceToCourse.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InsToCourse> getInsToCourseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InsToCourse.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<LengthToCourse> getLengthToCourseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LengthToCourse.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MarkToIns> getMarkToInsList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarkToIns.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentToIns> getStudentToInsList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentToIns.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterStudentNum> getRegisterStudentNumList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RegisterStudentNum.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterCourseNum> getRegisterCourseNumList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RegisterCourseNum.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<KindToCourse> getKindToCourseList() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(KindToCourse.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
}

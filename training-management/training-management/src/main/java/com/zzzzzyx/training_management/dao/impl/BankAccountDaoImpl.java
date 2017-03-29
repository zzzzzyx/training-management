package com.zzzzzyx.training_management.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzzzyx.training_management.dao.BankAccountDao;
import com.zzzzzyx.training_management.model.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addMoneyOfAnAccount(long cardNumber, long money) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BankAccount.class);
		criteria.add(Restrictions.eq("cardNumber", cardNumber));
		BankAccount bankAccount = (BankAccount) criteria.uniqueResult();
		bankAccount.setMoney(bankAccount.getMoney() + money);
		sessionFactory.getCurrentSession().save(bankAccount);
	}

	@Override
	public long getMoneyByNoAndPsw(BankAccount bankAccount) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BankAccount.class);
		criteria.add(Restrictions.eq("cardNumber", bankAccount.getCardNumber()));
		criteria.add(Restrictions.eq("password", bankAccount.getPassword()));
		if(criteria.list().isEmpty()){
			return -1;
		}
		return ((BankAccount)criteria.uniqueResult()).getMoney();
	}

	@Override
	public long getMoneyByBankAccountNumber(long bankAccountNo) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BankAccount.class);
		criteria.add(Restrictions.eq("cardNumber", bankAccountNo));
		if(criteria.list().isEmpty()){
			return -1;
		}
		return ((BankAccount)criteria.uniqueResult()).getMoney();
	}
	
	
}

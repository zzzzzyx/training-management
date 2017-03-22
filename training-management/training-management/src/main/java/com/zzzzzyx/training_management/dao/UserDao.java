package com.zzzzzyx.training_management.dao;

import com.zzzzzyx.training_management.model.User;

public interface UserDao {

	void save(User u);

	User getByUserId(long user_id);

	void toActivatedStatusAndRenewActivationDate(long auth_id);

	void deleteUserById(long auth_id);

}

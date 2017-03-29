package com.zzzzzyx.training_management.dao;

import java.util.List;

import com.zzzzzyx.training_management.model.log.ConsumeLog;

public interface ConsumeLogDao {

	void save(ConsumeLog cl);

	List<ConsumeLog> getConsumeLogListByUserId(long user_id);

	List<ConsumeLog> getConsumeLogListByInsId(long user_id);

	List<ConsumeLog> getCompleteLogListByConsumeKind(String consumeKind);

}

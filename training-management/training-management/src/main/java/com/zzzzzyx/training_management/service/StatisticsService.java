package com.zzzzzyx.training_management.service;

import java.util.List;

import com.zzzzzyx.training_management.vo.InstitutionVO;
import com.zzzzzyx.training_management.vo.UserVO;

public interface StatisticsService {

	List<InstitutionVO> getInsList();

	List<UserVO> getUserList();

}

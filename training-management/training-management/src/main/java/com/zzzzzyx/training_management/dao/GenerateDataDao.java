package com.zzzzzyx.training_management.dao;

import java.util.List;

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

public interface GenerateDataDao {

	void generateData();

	List<RegisterUserNum> getRegisterUserNumList();

	List<RegisterUserTotal> getRegisterUserTotalList();

	List<ComsumeLevel> getConsumeLevelList();

	List<AttendCourseLevel> getAttendCourseLevelList();

	List<MonthIncome> getMonthIncomeList();

	List<MonthIncomeRate> getMonthIncomeRateList();

	List<MonthIncomeIncrease> getMonthIncomeIncreaseList();

	List<PriceToCourse> getPriceToCourseList();

	List<LengthToCourse> getLengthToCourseList();

	List<InsToCourse> getInsToCourseList();

	List<MarkToIns> getMarkToInsList();

	List<StudentToIns> getStudentToInsList();

	List<RegisterStudentNum> getRegisterStudentNumList();

	List<RegisterCourseNum> getRegisterCourseNumList();

	List<KindToCourse> getKindToCourseList();

}

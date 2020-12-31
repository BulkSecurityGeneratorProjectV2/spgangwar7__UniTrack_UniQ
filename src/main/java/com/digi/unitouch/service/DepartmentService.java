package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.DepartmentHead;
import com.digi.unitouch.model.DepartmentRole;
import com.digi.unitouch.model.UserDepartment;
import com.digi.unitouch.vo.UserVo;

public interface DepartmentService {
	
	public List<Department> saveDeptDetails(Department department);
	
	public String deleteDept(Department department);

	public List<Department> getDepartmentsList();

	public List<Department> getDepartmentsByID(Department dept);

	public String getuserListByDepartmentsID(UserDepartment department);

	public String saveDepartmentHead(DepartmentHead deparmenthead); 
	
	public List<DepartmentHead> getDepartmentHeadList();

	public void deleteDepartmentHead(DepartmentHead deptHead);

	List<UserVo> getUserNameByDeptID(UserDepartment userDepartment);

	public void updateDepartmentHead(DepartmentHead departmentHead);

	public String getDepartmentByRoleID(Integer roleID);

	List<DepartmentRole> getDepartmentRoleId(Integer roleId);

//	Department getDepartmentsByID(Integer dept);

	

}

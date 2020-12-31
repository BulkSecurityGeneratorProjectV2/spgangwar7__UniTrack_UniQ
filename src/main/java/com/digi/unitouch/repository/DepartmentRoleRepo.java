package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.DepartmentRole;
import com.digi.unitouch.vo.DepartmentRoleVo;

public interface DepartmentRoleRepo extends JpaRepository<DepartmentRole, Integer> {

	 @Query(value ="SELECT dr FROM DepartmentRole dr WHERE dr.roleID=:roleID") 
	 public List<DepartmentRole> getDepartmentID(int roleID);
	 
	
	
	@Query(value=" SELECT new com.digi.unitouch.vo.DepartmentRoleVo(dr.roleID ,de.groupName,dr.deptID,0) FROM DepartmentRole dr JOIN Department de ON "
			+ "de.deptID=dr.deptID where dr.roleID=:roleId")
	 public List<DepartmentRoleVo> departmentIdbyRoleId(int roleId);

	
	 
}

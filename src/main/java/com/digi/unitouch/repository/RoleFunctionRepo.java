package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.RoleFunction;

public interface RoleFunctionRepo extends JpaRepository<RoleFunction, Integer> {

	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("update RoleFunction rf set rf.functionId=?2 where dh.roleId =?1 ")
	 * void updateRoleFunction(Integer roleID, Integer[] funcionId);
	 */
	
	@Modifying(clearAutomatically = true)
	@Query(value="delete from sys_role_function WHERE role_id=?1",nativeQuery = true)
	int  deleteByRoleFunctionID(int roleID);
	
	
	@Query(value="SELECT * FROM sys_role_function WHERE role_id=?1",nativeQuery=true)
	List<RoleFunction> getFunctionList(int roleid);

}

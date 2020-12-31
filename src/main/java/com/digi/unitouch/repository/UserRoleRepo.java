package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.vo.UserRoleVo;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

	 @Query(value ="SELECT ur FROM UserRole ur WHERE ur.roleId=:roleID") 
	 public List<UserRole> getUserID(int roleID);
	 
	 @Query(value ="SELECT ur FROM UserRole ur WHERE ur.roleId=:roleID and ur.userId=:userId") 
	 public UserRole getUserIDAndRoleID(int roleID,int userId);
	 
	@Query(value=" SELECT new com.digi.unitouch.vo.UserRoleVo(ur.roleId ,urs.firstName,urs.lastName,ur.userId,0) FROM UserRole ur "
			+ "JOIN Users urs ON "
			+ "urs.userID=ur.userId where ur.roleId=:roleId")
	 public List<UserRoleVo> usersbyRoleId(int roleId);
	

}

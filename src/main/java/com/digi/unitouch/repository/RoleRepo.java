package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r WHERE r.roleID =?1 ")
	List<Role> getRolesByID(Integer roleID);
	
	@Query("SELECT r FROM Role r WHERE r.roleID =?1")
	 Role getRoleByID(Integer roleID);
	
	@Query("SELECT r FROM Role r ORDER BY r.roleName DESC ")
	List<Role> findAllOrderby();


}

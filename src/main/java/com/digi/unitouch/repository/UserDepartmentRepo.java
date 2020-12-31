package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.UserDepartment;

public interface UserDepartmentRepo extends JpaRepository<UserDepartment, Integer> {
	
	@Query(value="SELECT * from user_department where dept_id=:deptID",nativeQuery = true)
	List<UserDepartment> getDepartmentsByID(int deptID);

//	@Query(value="SELECT * FROM user_department  WHERE user_id=:userId",nativeQuery = true)
//	List<UserDepartment> getDepartmentsByUserID(int userId);
//	
	@Modifying(clearAutomatically = true)
	@Query(value="delete from user_department WHERE user_id=:userId",nativeQuery = true)
	void deleteByUserID(int userId);
	
}

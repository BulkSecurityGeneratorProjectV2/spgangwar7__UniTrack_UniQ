package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{


	@Query("SELECT dept FROM Department dept WHERE dept.deptID=:deptID")
	List<Department> getDepartmentsByID(int deptID);

	@Query("SELECT dept FROM Department dept WHERE dept.deptID=:deptID")
	 Department getDepartmentsID(int deptID);	

}

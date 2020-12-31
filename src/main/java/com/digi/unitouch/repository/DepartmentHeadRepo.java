package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.DepartmentHead;

public interface DepartmentHeadRepo extends JpaRepository<DepartmentHead, Integer> {

	@Query("SELECT dh FROM DepartmentHead dh WHERE dh.deptID=?2 and dh.userId=?1")
	List<DepartmentHead> getDeptHeadDetailsByID(int userID,int deptID);

	@Modifying(clearAutomatically = true)
	@Query("update DepartmentHead dh set dh.userId=?2 where dh.deptID =?1 ")
	void updateDepartmentHead(Integer deptID, Integer userId);

}

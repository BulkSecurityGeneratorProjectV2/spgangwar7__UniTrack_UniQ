package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.ErrorProcess;

public interface ErrorProcessRepo extends JpaRepository<ErrorProcess, Integer>{

	@Query(value="SELECT e FROM ErrorProcess e WHERE e.taskid=:taskId")
	List<ErrorProcess> findByTaskId(Integer taskId);

}

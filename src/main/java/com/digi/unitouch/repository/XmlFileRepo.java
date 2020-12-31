package com.digi.unitouch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digi.unitouch.model.XmlFilePath;

@Repository
public interface XmlFileRepo extends JpaRepository<XmlFilePath, Integer> {

	Optional<XmlFilePath> findById(Integer xmlId);

	List<XmlFilePath> findByAidAndTaskid(Integer aid, Integer taskid);

	
}

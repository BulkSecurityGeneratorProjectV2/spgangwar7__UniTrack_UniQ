package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.CitiesList;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.StateList;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {

	@Query("SELECT p FROM Publisher p WHERE p.publisher_id=:publisher_id")
	List<Publisher> getPublisherByID(Integer publisher_id);

	@Query("SELECT s FROM StateList s WHERE s.countryId=:id")
	List<StateList> getAllStatelist(Integer id);
	
	@Query("SELECT c FROM CitiesList c WHERE c.state_id=:id")
	List<CitiesList> getAllcityList(Integer id);

}

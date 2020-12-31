package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.AuthorDataApiModel;

public interface AuthorDataApiModelRepo extends JpaRepository<AuthorDataApiModel, Integer> {

	@Query(value="Select adm from AuthorDataApiModel adm where adm.response_code!=:response_code and adm.transmit=:transmit")
	List<AuthorDataApiModel> findbyResponseCodeAndTransmit(String response_code, String transmit);

}

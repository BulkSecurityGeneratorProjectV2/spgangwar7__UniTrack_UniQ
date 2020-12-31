package com.digi.unitouch.serviceImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.CitiesList;
import com.digi.unitouch.model.Country;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.StateList;
import com.digi.unitouch.repository.CountryRepo;
import com.digi.unitouch.repository.PublisherRepo;
import com.digi.unitouch.service.PublisherService;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	PublisherRepo publisherRepo;
	
	@Override
	public List<Publisher> getallList() {
		return publisherRepo.findAll();
	}

	@Override
	public void deletePublisher(Publisher pub) {
		publisherRepo.delete(pub);
	}

	@Override
	public List<Country> getCountryList() {
		return countryRepo.findAll(sortByNameAsc());
	}
	
	 private Sort sortByNameAsc() {
	        return new Sort(Sort.Direction.ASC, "countryName");
	    }

	@Override
	public void saveNewPublisher(Publisher pub) {
		publisherRepo.save(pub);
		
	}

	@Override
	public List<Publisher> getPublisherByID(Publisher pub) {
		return publisherRepo.getPublisherByID(pub.getPublisher_id());
	}

	@Override
	public List<StateList> getAllStatelist(Integer id) {
		return publisherRepo.getAllStatelist(id);
	}

	@Override
	public List<CitiesList> getAllcityList(Integer id) {
		return publisherRepo.getAllcityList(id);
	}

}

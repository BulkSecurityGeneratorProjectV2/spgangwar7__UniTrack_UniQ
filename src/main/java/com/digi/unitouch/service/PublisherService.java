package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.CitiesList;
import com.digi.unitouch.model.Country;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.StateList;

public interface PublisherService {
	
	public List<Publisher> getallList();

	public void deletePublisher(Publisher pub);

	public List<Country> getCountryList();

	public void saveNewPublisher(Publisher pub);

	public List<Publisher> getPublisherByID(Publisher pub);

	public List<StateList> getAllStatelist(Integer id);

	public List<CitiesList> getAllcityList(Integer id);

}

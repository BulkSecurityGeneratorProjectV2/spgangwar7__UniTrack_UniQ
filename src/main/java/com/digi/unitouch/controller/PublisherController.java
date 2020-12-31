package com.digi.unitouch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.ApplicationResponse;
import com.digi.unitouch.model.CitiesList;
import com.digi.unitouch.model.Country;
import com.digi.unitouch.model.Publisher;
import com.digi.unitouch.model.StateList;
import com.digi.unitouch.service.PublisherService;
import com.digi.unitouch.util.LoggerClass;



@Controller
public class PublisherController extends LoggerClass{
	
	@Autowired
	PublisherService pubService;
	
	@GetMapping("publisherDetails")
	public ModelAndView publisherDetails(ModelMap model) {
		List<Publisher> pubList = pubService.getallList();
		model.addAttribute("pubList", pubList);
		return new ModelAndView("publisher");
	}
	
	@GetMapping("createNewPublisher")
	public ModelAndView createNewRole(ModelMap model) {
		List<Country> countryList = pubService.getCountryList();
		model.addAttribute("countryList", countryList);
		return new ModelAndView("createPublisher");
	}
	
	
	@RequestMapping(value = "/state-List-{id}", method = RequestMethod.GET)
	public ResponseEntity<ApplicationResponse> StateList(@PathVariable("id") Integer id, ModelMap model, HttpServletRequest request) {
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		try {
			List<StateList> Statelist = pubService.getAllStatelist(id);
			model.put("Statelist", Statelist);
			applicatonResponse.setPayload(Statelist);
			applicatonResponse.setMessage("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/city-List-{id}", method = RequestMethod.GET)
	public ResponseEntity<ApplicationResponse> cityList(@PathVariable("id") Integer id, ModelMap model, HttpServletRequest request) {
		ApplicationResponse applicatonResponse = new ApplicationResponse();
		try {
			List<CitiesList> cityList = pubService.getAllcityList(id);
			model.put("cityList", cityList);
			applicatonResponse.setPayload(cityList);
			applicatonResponse.setMessage("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ApplicationResponse>(applicatonResponse, HttpStatus.OK);
	}
	
	
	
	@PostMapping("saveNewPublisher")
	public String saveNewPublisher(Publisher pub, HttpServletRequest request,ModelMap model) {
		pubService.saveNewPublisher(pub);
		return "redirect:publisherDetails";
	}
	
	@PostMapping("editPublisherDetails")
	public ModelAndView editPublisherDetails(Publisher pub,ModelMap model, HttpServletRequest request) {
		List<Publisher> pubList = pubService.getPublisherByID(pub);
		model.addAttribute("pubList", pubList.get(0));
		List<Country> countryList = pubService.getCountryList();
		model.addAttribute("countryList", countryList);
		return new ModelAndView("editPublisherDetails");
	}
	
	@PostMapping("updatePublisherDetails")
	public String updatePublisherDetails(Publisher pub, HttpServletRequest request,ModelMap model) {
		pubService.saveNewPublisher(pub);
		List<Publisher> pubList = pubService.getallList();
		model.addAttribute("pubList", pubList);
		return "redirect:publisherDetails";
	}
	
	@PostMapping("deletePublisher")
	public String deleteRole(Publisher pub, HttpServletRequest request,ModelMap model) {
		pubService.deletePublisher(pub);
		return "redirect:publisherDetails";
	}
	
}

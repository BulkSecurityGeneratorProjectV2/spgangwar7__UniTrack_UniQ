package com.digi.unitouch.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.XmlFilePath;
import com.digi.unitouch.repository.XmlFileRepo;
import com.digi.unitouch.service.XmlFileService;

@Service
@Transactional
public class XmlFileServiceImpl implements XmlFileService {

	@Autowired
	XmlFileRepo xmlfileRepo;

	@Override
	public List<XmlFilePath> getAllList() {

		return xmlfileRepo.findAll();
	}

	@Override
	public Optional<XmlFilePath> findById(Integer id) {
		return xmlfileRepo.findById(id);
	}

	@Override
	public List<XmlFilePath> findByAidAndTaskId(Integer aid, Integer taskid) {

		return xmlfileRepo.findByAidAndTaskid(aid, taskid);
	}

	@Override
	public void saveXmlPath(XmlFilePath xmlFilePath) {
		xmlfileRepo.save(xmlFilePath);

	}

}

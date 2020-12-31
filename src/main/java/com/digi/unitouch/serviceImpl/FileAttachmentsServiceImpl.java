package com.digi.unitouch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.FileAttachments;
import com.digi.unitouch.repository.FileAttachmentsRepo;
import com.digi.unitouch.service.FileAttachmentsService;

@Service
public class FileAttachmentsServiceImpl implements FileAttachmentsService{

	@Autowired
	FileAttachmentsRepo fileAttachmentsRepo;
	@Override
	public void save(FileAttachments fileAttachments) {
		fileAttachmentsRepo.saveAndFlush(fileAttachments);
		
	}

	@Override
	public List<FileAttachments> findAll() {
		return fileAttachmentsRepo.findAll();
	}

	@Override
	public List<FileAttachments> findByArticle(int articleID, Integer journalId) {
		// TODO Auto-generated method stub
		return fileAttachmentsRepo.findByAidAndJid(articleID,journalId);
	}

}

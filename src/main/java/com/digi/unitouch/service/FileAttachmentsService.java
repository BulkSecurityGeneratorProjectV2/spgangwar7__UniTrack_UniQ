package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.FileAttachments;

public interface FileAttachmentsService {

	public void save(FileAttachments fileAttachments);

	public List<FileAttachments> findAll();

	public List<FileAttachments> findByArticle(int articleID, Integer journalId);
}

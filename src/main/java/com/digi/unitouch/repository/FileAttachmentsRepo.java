package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.unitouch.model.FileAttachments;

public interface FileAttachmentsRepo extends JpaRepository<FileAttachments, Integer>{

	List<FileAttachments> findByAidAndJid(int articleID, Integer journalId);

}

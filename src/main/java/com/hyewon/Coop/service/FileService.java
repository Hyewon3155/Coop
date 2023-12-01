package com.hyewon.Coop.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.repository.FileRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Member;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.ResultData;

@Service
public class FileService {
	@Value("${file.dir}")
	private String fileDir;

	
	private FileRepository fileRepository;
	
	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	public void doReference(int loginedMemberId, int project_id, String title, MultipartFile file, String body)  throws IOException{
		if (file.isEmpty()) {
			return;
		}
		
		String orgName = file.getOriginalFilename();
		
		String uuid = UUID.randomUUID().toString();
		
		String extension = orgName.substring(orgName.lastIndexOf("."));
		
		String savedName = uuid + extension;
		
		String savedPath = fileDir + "/" + savedName;
		
		fileRepository.doReference(loginedMemberId, project_id, title, savedPath, body);
	}
	
	public int getLastInsertId() {
		return fileRepository.getLastInsertId();
	}

	
}
package com.hyewon.Coop.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.repository.FileRepository;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.File;
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
		
        file.transferTo(Paths.get(savedPath));

		fileRepository.doReference(loginedMemberId, project_id, title, savedPath, body, orgName);
	}
	
	public int getLastInsertId() {
		return fileRepository.getLastInsertId();
	}

	public int getReferenceCount(int id) {
	   return fileRepository.getReferenceCount(id);
	}

	public List<File> getReferences(int itemsInAPage, int page, int id) {
	     
		int limitStart = (page - 1) * itemsInAPage;
		
		return fileRepository.getReferences(limitStart, itemsInAPage, id);
	}

	public File getFileById(int id) {
		return fileRepository.getFileById(id);
	}
	
	public ResultData actorCanMD(int loginedMemberId, File file) {
		if(file == null) {
			return ResultData.from("F-1", "해당 게시물은 존재하지 않습니다");
		}
		
		if (loginedMemberId != file.getMember_id()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");	
		}
		
		return ResultData.from("S-1", "가능");
	}

	public void doReferenceModify(int loginedMemberId, int id, String title, MultipartFile file, String body) throws IOException {
		
		if (((MultipartFile) file).isEmpty()) {
			return;
		}
		
		String orgName = ((MultipartFile) file).getOriginalFilename();
		
		String uuid = UUID.randomUUID().toString();
		
		String extension = orgName.substring(orgName.lastIndexOf("."));
				
		String savedName = uuid + extension;
		
		String savedPath = fileDir + "/" + savedName;
		
        ((MultipartFile) file).transferTo(Paths.get(savedPath));
        
		fileRepository.doReferenceModify(loginedMemberId, title, savedPath, body, orgName);

		
	}

	public void referenceDelete(int id) {
		fileRepository.referenceDelete(id);
	}

	
}
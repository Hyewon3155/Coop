package com.hyewon.Coop.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyewon.Coop.service.FileService;
import com.hyewon.Coop.util.Util;
import com.hyewon.Coop.vo.Task;
import com.hyewon.Coop.vo.File;
import com.hyewon.Coop.vo.Notice;
import com.hyewon.Coop.vo.Project;
import com.hyewon.Coop.vo.ResultData;
import com.hyewon.Coop.vo.Rq;

@Controller
public class UsrFileController {
	private FileService fileService;
	private Rq rq;
	
	public UsrFileController(FileService fileService, Rq rq) {
		this.fileService = fileService;
		this.rq = rq;
	}
	
	@RequestMapping("/user/myWork/reference")
	public String showMyWorkRefernce(Model model, int id) {
		model.addAttribute("project_id", id);
		return "user/myWork/reference";
	}
	
	@RequestMapping("/user/myWork/doReference")
	@ResponseBody
	public String doReference(int project_id, String title, MultipartFile file, String body) {
		
		if (Util.empty(title)) {
			return Util.jsHistoryBack("제목을 입력해주세요");
		}

		if (Util.empty(body)) {
			return Util.jsHistoryBack("내용을 입력해주세요");
		}
		
		
		try {
			fileService.doReference(rq.getLoginedMemberId(), project_id, title, file, body);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int id = fileService.getLastInsertId();

		return Util.jsReplace(Util.f("작업물이 업로드되었습니다", id), Util.f("referenceDetail?id=%d&project_id=%d", id, project_id));
	}
	
	@RequestMapping("/user/myWork/referenceCheck")
	public String showList(Model model,
			@RequestParam(defaultValue = "1") int page, int id) {

		if (page <= 0) {
			return rq.jsReturnOnView("페이지번호가 올바르지 않습니다", true);
		}

		int referencesCnt = fileService.getReferenceCount(id);

		int itemsInAPage = 10;

		int pagesCount = (int) Math.ceil((double) referencesCnt / itemsInAPage);

		List<File> references = fileService.getReferences(itemsInAPage, page, id);

		model.addAttribute("pagesCount", pagesCount);
		model.addAttribute("page", page);
		model.addAttribute("referencesCnt", referencesCnt);
		model.addAttribute("references", references);
		model.addAttribute("project_id", id);

		return "user/myWork/referenceCheck";
	}
	
	@RequestMapping("/user/myWork/referenceDetail")
	public String showDetail(Model model, int id, int project_id) {

        File file = fileService.getFileById(id);
        
        model.addAttribute("file", file);
        model.addAttribute("project_id", project_id);
	
		return "user/myWork/referenceDetail";
	}
	
	@GetMapping("/file/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int id) throws IOException {
        File file = fileService.getFileById(id);
        Path path = Paths.get(file.getFile_savedPath());
        Resource resource = new UrlResource(path.toUri());

        String contentDisposition = "attachment; filename=\"" + path.getFileName().toString() + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    } 
	
	@RequestMapping("/user/myWork/referenceModify")
	public String modify(Model model, int id, int project_id) {

		File file = fileService.getFileById(id);

		ResultData actorCanMD = fileService.actorCanMD(rq.getLoginedMemberId(), file);

		if (actorCanMD.isFail()) {
			return rq.jsReturnOnView(actorCanMD.getMsg(), true);
		}

		model.addAttribute("file", file);
		model.addAttribute("project_id", project_id);


		return "user/myWork/referenceModify";
	}
	
	@RequestMapping("/user/myWork/doReferenceModify")
	@ResponseBody
	public String doReferenceModify(int id, int project_id, String title, MultipartFile file, String body ) {

		File file1 = fileService.getFileById(id);

		ResultData actorCanModifyRd = fileService.actorCanMD(rq.getLoginedMemberId(), file1);

		if (actorCanModifyRd.isFail()) {
			return Util.jsHistoryBack(actorCanModifyRd.getMsg());
		}
		try {
			fileService.doReferenceModify(rq.getLoginedMemberId(), id, title, file, body);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Util.jsReplace(Util.f("%d번 게시물을 수정했습니다", id), Util.f("referenceDetail?id=%d&project_id=%d", id, project_id));
	}
	
	@RequestMapping("/user/myWork/referenceDelete")
	@ResponseBody
	public String referenceDelete(int id, int project_id) {

		File file = fileService.getFileById(id);

		ResultData actorCanModifyRd = fileService.actorCanMD(rq.getLoginedMemberId(), file);

		if (actorCanModifyRd.isFail()) {
			return Util.jsHistoryBack(actorCanModifyRd.getMsg());
		}

		fileService.referenceDelete(id);

		return Util.jsReplace(Util.f("%d번 게시물을 삭제했습니다", id), Util.f("referenceCheck?id=%d", project_id));
	}
	
	

}


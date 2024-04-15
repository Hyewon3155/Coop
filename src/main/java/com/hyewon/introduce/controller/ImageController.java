package com.hyewon.introduce.controller;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hyewon.introduce.service.ProfileService;
import com.hyewon.introduce.vo.Profile;

@RestController
public class ImageController {
	ProfileService profileService;
	
	public ImageController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@GetMapping("/file/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int id) throws IOException {
        Profile profile = profileService.getProfileById(id);
        Path path = Paths.get(profile.getFilePath());
        Resource resource = new UrlResource(path.toUri());

        String contentDisposition = "attachment; filename=\"" + path.getFileName().toString() + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    } 

}

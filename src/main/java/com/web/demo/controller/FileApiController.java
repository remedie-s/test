/**
 * 파일 업로드 화면 제공
 * 파일 업로드 실제 처리 제공
 * 파일 다운로드 실제 처리 제공
 * 단, 클라우드 상 스토리지 저장은 생략, 데이터 베이스 연동 생략
 * URL prefix /file, 컨트롤러 설정
 * 테스트 편의상 jwt, csrf 설정 고려
 */
package com.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/file")
@Controller
public class FileApiController {
	// 파일업로드 화면제공
	@GetMapping("/upload")
	public String upload() {
		return "file_process"; // file_process.html 생성
	}
	
	// 파일 업로드 실제 처리 제공
	// 일반 데이터 + 파일 동시 전송
	@PostMapping("/upload")
	@ResponseBody
	public String upload( MemberDto member,// 나이, 이름, 주소 정보를 통으로 받아서 전달
			@RequestParam("uploadFile") MultipartFile uploadFile, // 파일을 받아서 전달
			HttpServletRequest req) {
		// 1. 파일 저장할 결로 획득 (여기서는 톰캣 내부, 실제로는 클라우드의 스토리지 선택)
		String path = req.getServletContext().getRealPath("");// 저장할 위치(서버측)
		System.out.println("path:"+path);
		String filename = uploadFile.getOriginalFilename();// 파일명
		// 2. 저장
		// 3. 결과 응답
		
		
		return "응답";
	}
	// 파일 다운로드 실제 처리 제공
//	@RequestMapping("/upload")
//	public String download() {
//		return "";
//	}
	

}

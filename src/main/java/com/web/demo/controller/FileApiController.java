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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/file")
@Controller
public class FileApiController {
	// 파일업로드 화면제공
	@GetMapping("/upload")
	public String upload() {
		return "file_process"; // file_process.html 생성
	}
//	// 파일 업로드 실제 처리 제공
//	// 일반 데이터 + 파일 동시 전송
//	@PatchMapping("/upload")
//	public String upload() {
//		return "";
//	}
//	// 파일 다운로드 실제 처리 제공
//	@RequestMapping("/upload")
//	public String download() {
//		return "";
//	}
	

}

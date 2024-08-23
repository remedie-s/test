package com.web.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.dto.PostForm;
import com.web.demo.entity.Post;
import com.web.demo.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RestApiController {
	private final PostService postService;
	
	// get 
//	@GetMapping("/post/detail/{id}")
//	public String list(@PathVariable("id") Integer id, Model model) {
//		Post onePost = postService.getOnePost(id);
//		model.addAttribute(onePost);		
//		return "post_detail";
//	}
	@GetMapping("/post/{id}")
	// 특정번호 입력하면 데이터를 가져오는 메소드구현
	// <문제점>
	// 본글에 참조키로 연결된 리뷰 데이터가 존재할 경우 응답값이 무한 반복이됨
	// 본글만 있으면 문제 없음
	// 노출되면 안되는 값들도 모두 전달된다.
	public Post post(@PathVariable("id") Integer id) {
		Post p = postService.getOnePost(id);
		return p;
	}
	
	@GetMapping("/post2/{id}")
	// DTO 사용시 원하는 데이터만 추추락능(통제가능)
	// Post=> PostForm으로 대체 : 보안상의 문제로 컨트롤러에서는 엔티티가 노출되면 안됨 -> dto로 대체
	public PostForm post2(@PathVariable("id") Integer id) {
		PostForm p = postService.getOnePostForm(id);
		return p;
	}
	
//	@GetMapping("/post3/{id}")
	// 특정번호 입력하면 데이터를 가져오는 메소드구현
	// <문제점>
	// 본글에 참조키로 연결된 리뷰 데이터가 존재할 경우 응답값이 무한 반복이됨
	// 본글만 있으면 문제 없음
	// 노출되면 안되는 값들도 모두 전달된다.
	public ResponseEntity<Post> post3(@PathVariable("id") Integer id) {
		Post p = postService.getOnePost(id);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	// post
	
	// put
	
	// delete
	
}

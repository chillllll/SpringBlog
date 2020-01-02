package com.suh.view.blog;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.suh.biz.blog.BlogVO;
import com.suh.biz.blog.impl.BlogDAOImpl;
import com.suh.biz.blog.impl.BlogService;


@Controller
@SessionAttributes("blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	// 글 목록 검색
		@RequestMapping("/getPostList.do")
		public String getBoardList(BlogVO vo, Model model)throws Exception {
			/* Null Check
			if (vo.getSearchCondition() == null)
				vo.setSearchCondition("TITLE");
			if (vo.getSearchKeyword() == null)
				vo.setSearchKeyword("");
			 Model 정보 저장*/
			model.addAttribute("boardList", blogService.getPostList(vo));
			return "getBoardList.jsp"; // View 이름 리턴
		}
		
		// 글 등록
		@RequestMapping(value = "/insertBoard.do")
		public String insertBoard(BlogVO vo) throws Exception {
			// 파일 업로드 처리
			MultipartFile uploadFile = vo.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File("D:/" + fileName));
			}

			blogService.insertPost(vo);
			return "getBoardList.do";
		}

		// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BlogVO vo) throws Exception{
			blogService.updatePost(vo);
			return "getBoardList.do";
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BlogVO vo) throws Exception {
			blogService.deletePost(vo);
			return "getBoardList.do";
		}

		// 글 상세 조회
		@RequestMapping("/getBoard.do")
		public String getBoard(BlogVO vo, Model model) throws Exception {
			model.addAttribute("board", blogService.getPost(vo)); // Model 정보 저장
			return "getBoard.jsp"; // View 이름 리턴
		}

}

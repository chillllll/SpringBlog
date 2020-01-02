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
	
	// �� ��� �˻�
		@RequestMapping("/getPostList.do")
		public String getBoardList(BlogVO vo, Model model)throws Exception {
			/* Null Check
			if (vo.getSearchCondition() == null)
				vo.setSearchCondition("TITLE");
			if (vo.getSearchKeyword() == null)
				vo.setSearchKeyword("");
			 Model ���� ����*/
			model.addAttribute("boardList", blogService.getPostList(vo));
			return "getBoardList.jsp"; // View �̸� ����
		}
		
		// �� ���
		@RequestMapping(value = "/insertBoard.do")
		public String insertBoard(BlogVO vo) throws Exception {
			// ���� ���ε� ó��
			MultipartFile uploadFile = vo.getUploadFile();
			if (!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File("D:/" + fileName));
			}

			blogService.insertPost(vo);
			return "getBoardList.do";
		}

		// �� ����
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BlogVO vo) throws Exception{
			blogService.updatePost(vo);
			return "getBoardList.do";
		}

		// �� ����
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BlogVO vo) throws Exception {
			blogService.deletePost(vo);
			return "getBoardList.do";
		}

		// �� �� ��ȸ
		@RequestMapping("/getBoard.do")
		public String getBoard(BlogVO vo, Model model) throws Exception {
			model.addAttribute("board", blogService.getPost(vo)); // Model ���� ����
			return "getBoard.jsp"; // View �̸� ����
		}

}

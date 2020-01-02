package com.suh.biz.blog.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suh.biz.blog.BlogVO;
import com.suh.biz.blog.impl.BlogDAOImpl;

@Service("blogservice")
public class BlogService {
	@Autowired
	private BlogDAOImpl blogDAO;
	
	public void insertPost(BlogVO vo) throws Exception {
		blogDAO.insertPost(vo);
	}

	public void updatePost(BlogVO vo) throws Exception {
		blogDAO.updatePost(vo);
	}

	public void deletePost(BlogVO vo) throws Exception {
		blogDAO.deletePost(vo);
	}

	public BlogVO getPost(BlogVO vo) throws Exception {
		return blogDAO.getPost(vo);
	}

	public List<BlogVO> getPostList(BlogVO vo) throws Exception {
		return blogDAO.getPostList(vo);
	}

}

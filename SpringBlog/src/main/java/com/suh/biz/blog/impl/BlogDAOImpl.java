package com.suh.biz.blog.impl;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.suh.biz.blog.BlogVO;

@Repository
public class BlogDAOImpl {
	
	@Inject
	private SqlSessionTemplate sqlSession;
		
	public List<BlogVO> getPostList(BlogVO vo) throws Exception {
		System.out.println("=====getPostList���ȣ��=======");
		return sqlSession.selectList("BlogDAO.getPostList");
	}
	public BlogVO getPost(BlogVO vo) throws Exception {
		System.out.println("=====getPost���ȣ��=======");
		return sqlSession.selectOne("BlogDAO.getPost", vo);
	}
	public void insertPost(BlogVO vo) throws Exception{
		System.out.println("=====insertPost���ȣ��=======");
		sqlSession.insert("BlogDAO.insertPost", vo);
	}
	public void updatePost(BlogVO vo) throws Exception {
		System.out.println("=====updatePost���ȣ��=======");
		sqlSession.update("BlogDAO.updatePost",vo);
	}
	public void deletePost(BlogVO vo) throws Exception {
		System.out.println("=====deletePost���ȣ��=======");
		sqlSession.delete("BlogDAO.deletePost", vo);
	}
	public void updateViewCnt(BlogVO vo) throws Exception {
		System.out.println("=====viewcnt���ȣ��=======");
		sqlSession.update("BlogDAO.updateViewCnt",vo);
	}

}

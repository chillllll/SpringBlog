package com.suh.biz.blog;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

public class BlogVO {
	private int num;
	private String category;
	private String title;
	private String content;
	private String tag;
	private int viewcnt;
	private String regid;
	private Date regdt;
	private Date editdt;
	@XmlTransient
	private MultipartFile uploadFile;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategory() {
		return category;
	}
		
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public Date getRegdt() {
		return regdt;
	}
	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
	public Date getEditdt() {
		return editdt;
	}
	public void setEditdt(Date editdt) {
		this.editdt = editdt;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "BlogVO [num=" + num + ", category=" + category + ", title=" + title + ", content=" + content + ", tag="
				+ tag + ", viewcnt=" + viewcnt + ", regid=" + regid + ", regdt=" + regdt + ", editdt=" + editdt + "]";
	}

}

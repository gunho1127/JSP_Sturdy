package com.ssamz.biz.board;

import java.sql.Date;

import lombok.Data;
/*
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
@Data
// VO(Value Object) 클래스
public class BoardVO {
	
	// 필드
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 검색 관련 변수
	private String searchCondition;
	private String searchKeyword;
	
	
/*	
	// getter/setter 메소드
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regDate;
	}
	public void setRegdate(Date regdate) {
		this.regDate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	// toString 메소드
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer +
				", content=" + content + ", regDate=" + regDate + ", cnt=" + cnt + 
				"]";
	}
*/
	
}

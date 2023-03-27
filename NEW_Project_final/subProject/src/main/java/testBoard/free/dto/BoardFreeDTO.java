package testBoard.free.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardFreeDTO {

	/*
	 * CREATE TABLE board ( board_code number CONSTRAINT board_code_seq PRIMARY KEY,
	 * customer_code number not null, --FK title varchar2(50), content
	 * varchar2(1000), regdate date default sysdate, moddate date default sysdate );
	 */

	private int board_code;
	private int customer_code;
	private String title;
	private String content;
	private Date regdate;
	private Date moddate;
	private int readcount;

	private String upload; // board테이블의 파일 첨부를 처리해주는 멤버변수
	private MultipartFile filename; // html form 페이지에서 파일 첨부를 받아 처리해주는 멤버변수 //파일 정보

	public BoardFreeDTO() {

	}

	public int getBoard_code() {
		return board_code;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public int getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(int customer_code) {
		this.customer_code = customer_code;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getmoddate() {
		return moddate;
	}

	public void setmoddate(Date moddate) {
		this.moddate = moddate;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BoardFreeDTO [board_code=" + board_code + ", customer_code=" + customer_code + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", moddate=" + moddate + ", readcount=" + readcount
				+ ", upload=" + upload + ", filename=" + filename + "]";
	}
	
	

}

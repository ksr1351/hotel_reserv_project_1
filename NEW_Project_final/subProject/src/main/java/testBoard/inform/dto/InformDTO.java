package testBoard.inform.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class InformDTO {

	/*
	CREATE TABLE board (
	    board_code number CONSTRAINT board_code_seq PRIMARY KEY,
	    customer_code number not null, --FK
	    title varchar2(50),
	    content varchar2(1000),
	    regdate date default sysdate,
	    moddate date default sysdate
	);
	*/
		
		private int notice_code;
		private String admin_id;
		private String title;
		private String content;
		private Date regdate;
		private int readcount;
		private Date moddate;
		
		private String upload; // board테이블의 파일 첨부를 처리해주는 멤버변수
		private MultipartFile filename; // html form 페이지에서 파일 첨부를 받아 처리해주는 멤버변수 //파일 정보
		
		public InformDTO() {

		}
		
		public int getNotice_code() {
			return notice_code;
		}
		public void setNotice_code(int notice_code) {
			this.notice_code = notice_code;
		}
		public String getAdmin_id() {
			return admin_id;
		}
		public void setAdmin_id(String admin_id) {
			this.admin_id = admin_id;
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
		public int getReadcount() {
			return readcount;
		}
		public void setReadcount(int readcount) {
			this.readcount = readcount;
		}
		public Date getModdate() {
			return moddate;
		}
		public void setModdate(Date moddate) {
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
		
}// end class

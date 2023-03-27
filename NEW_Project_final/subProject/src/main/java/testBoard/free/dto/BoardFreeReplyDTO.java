package testBoard.free.dto;

import java.util.Date;

public class BoardFreeReplyDTO {

	/*
	 * CREATE TABLE board_reply ( 
	 * board_code number not null, --FK 
	 * reply_code number CONSTRAINT reply_code_seq PRIMARY KEY, 
	 * content varchar2(1000), 
	 * customer_code number not null, --FK 
	 * regdate date default sysdate);
	 */
	
	private int board_code;
	private int reply_code;
	private String content;
	private int customer_code;
	private Date regdate;
	
	
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public int getReply_code() {
		return reply_code;
	}
	public void setReply_code(int reply_code) {
		this.reply_code = reply_code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(int customer_code) {
		this.customer_code = customer_code;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardFreeReplyDTO [board_code=" + board_code + ", reply_code=" + reply_code + ", content=" + content + ", customer_code=" + customer_code + ", regdate="
				+ regdate + "]";
	}
	
	
}

package testBoard.login.dto;

public class SessionDTO {
	
	private int mem_code;
	private String mem_Id;
	private String mem_Name;
	
	
	public SessionDTO() {
	}


	public SessionDTO(String mem_Id, String mem_Name) {
		this.mem_Id = mem_Id;
		this.mem_Name = mem_Name;
	}

	




	public SessionDTO(int mem_code, String mem_Id, String mem_Name) {
		this.mem_code = mem_code;
		this.mem_Id = mem_Id;
		this.mem_Name = mem_Name;
	}

	
	

	public int getMem_code() {
		return mem_code;
	}


	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}


	public String getMem_Id() {
		return mem_Id;
	}


	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}


	public String getMem_Name() {
		return mem_Name;
	}


	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}


	@Override
	public String toString() {
		return "SessionDTO [mem_code=" + mem_code + ", mem_Id=" + mem_Id + ", mem_Name=" + mem_Name + "]";
	}


	
	
	
	
	
	
	
}

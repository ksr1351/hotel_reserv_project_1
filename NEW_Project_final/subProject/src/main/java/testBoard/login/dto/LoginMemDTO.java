package testBoard.login.dto;

import javax.validation.constraints.NotBlank;

public class LoginMemDTO {
	
	private int mem_code;
	
	@NotBlank
	private String mem_Id;
	
	@NotBlank
	private String mem_Pwd;
	
	private String mem_Name;
	
	private String memberType;
	
	public LoginMemDTO() {
			
	}

	
	public LoginMemDTO(int mem_code, @NotBlank String mem_Id, @NotBlank String mem_Pwd, String mem_Name,
			String memberType) {
		this.mem_code = mem_code;
		this.mem_Id = mem_Id;
		this.mem_Pwd = mem_Pwd;
		this.mem_Name = mem_Name;
		this.memberType = memberType;
	}

	
    


	public int getMem_code() {
		return mem_code;
	}


	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}


	public String getMemberType() {
		return memberType;
	}


	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}


	public LoginMemDTO(@NotBlank String mem_Id) {
		this.mem_Id = mem_Id;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}

	public String getMem_Pwd() {
		return mem_Pwd;
	}

	public void setMem_Pwd(String mem_Pwd) {
		this.mem_Pwd = mem_Pwd;
	}

	public String getMem_Name() {
		return mem_Name;
	}

	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}


	@Override
	public String toString() {
		return "LoginMemDTO [mem_code=" + mem_code + ", mem_Id=" + mem_Id + ", mem_Pwd=" + mem_Pwd + ", mem_Name="
				+ mem_Name + ", memberType=" + memberType + "]";
	}


		
	
	
	
}

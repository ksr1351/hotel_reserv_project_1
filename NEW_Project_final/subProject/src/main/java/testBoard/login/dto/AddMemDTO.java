package testBoard.login.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;



public class AddMemDTO {
	
	private int mem_code;
	
	
	@NotBlank
	@Length(min=8,max=16)
	private String mem_Id;
	
	@NotBlank
	@Length(min=8,max=16)
	private String mem_Pwd;
	
	@NotBlank
	@Length(min=2,max=12)
	private String mem_Name;
	
	@NotNull
	@Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
	private String mem_Phone;
	
	@NotBlank
	@Email(message = "메일의 양식을 지켜주세요.")
	private String mem_Email;
	
	@NotBlank
	private String memberType;
	
	public AddMemDTO() {
	}
	
	
	

	public AddMemDTO(@NotBlank @Length(min = 8, max = 16) String mem_Id,
			@NotBlank @Length(min = 8, max = 16) String mem_Pwd, @NotBlank @Length(min = 2, max = 12) String mem_Name,
			@NotNull @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다") String mem_Phone,
			@NotBlank @Email(message = "메일의 양식을 지켜주세요.") String mem_Email, @NotBlank String memberType) {
		
		this.mem_Id = mem_Id;
		this.mem_Pwd = mem_Pwd;
		this.mem_Name = mem_Name;
		this.mem_Phone = mem_Phone;
		this.mem_Email = mem_Email;
		this.memberType = memberType;
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

	public String getMem_Phone() {
		return mem_Phone;
	}

	public void setMem_Phone(String mem_Phone) {
		this.mem_Phone = mem_Phone;
	}

	public String getMem_Email() {
		return mem_Email;
	}

	public void setMem_Email(String mem_Email) {
		this.mem_Email = mem_Email;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "AddMemDTO [mem_code=" + mem_code + ", mem_Id=" + mem_Id + ", mem_Pwd=" + mem_Pwd + ", mem_Name="
				+ mem_Name + ", mem_Phone=" + mem_Phone + ", mem_Email=" + mem_Email + ", memberType=" + memberType
				+ "]";
	}

	
	
	
	

	

	
	
	
	
	
	
}

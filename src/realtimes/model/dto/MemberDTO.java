package realtimes.model.dto;

public class MemberDTO {
	
	private int memberCode;
	private String username;
	private String password;
	
	public MemberDTO(int memberCode, String username, String password) {
		super();
		this.memberCode = memberCode;
		this.username = username;
		this.password = password;
	}
	
	public int getMemberCode() {
		return memberCode;
	}
	
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [memberCode=").append(memberCode).append(", username=").append(username)
				.append(", password=").append(password).append("]");
		return builder.toString();
	}

}

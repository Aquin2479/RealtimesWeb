package realtimes.model.dto;

public class TestDTO {
	
	private int testCode;
	private String detail;
	
	public TestDTO(int testCode, String detail) {
		super();
		this.testCode = testCode;
		this.detail = detail;
	}
	
	public int getTestCode() {
		return testCode;
	}
	
	public void setTestCode(int testCode) {
		this.testCode = testCode;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}

}

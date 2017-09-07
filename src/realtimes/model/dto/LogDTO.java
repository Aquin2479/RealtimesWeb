package realtimes.model.dto;

public class LogDTO {
	
	private int log_code;
	private String username;
	private String news_code;
	private String viewing_time;
	
	public LogDTO(int log_code, String username, String news_code, String viewing_time) {
		super();
		this.log_code = log_code;
		this.username = username;
		this.news_code = news_code;
		this.viewing_time = viewing_time;
	}
	
	public int getLog_code() {
		return log_code;
	}
	
	public void setLog_code(int log_code) {
		this.log_code = log_code;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNews_code() {
		return news_code;
	}
	public void setNews_code(String news_code) {
		this.news_code = news_code;
	}
	
	public String getViewing_time() {
		return viewing_time;
	}
	
	public void setViewing_time(String viewing_time) {
		this.viewing_time = viewing_time;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LogDTO [log_code=").append(log_code).append(", username=").append(username)
				.append(", news_code=").append(news_code).append(", viewing_time=").append(viewing_time).append("]");
		return builder.toString();
	}

}

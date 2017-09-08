package realtimes.model.dto;

public class LogDTO {
	
	private int log_code;
	private int member_code;
	private String news_code;
	private int topic;
	private String viewing_time;
	
	public LogDTO(int log_code, int member_code, String news_code, int topic, String viewing_time) {
		super();
		this.log_code = log_code;
		this.member_code = member_code;
		this.topic = topic;
		this.news_code = news_code;
		this.viewing_time = viewing_time;
	}
	
	public int getLog_code() {
		return log_code;
	}
	
	public void setLog_code(int log_code) {
		this.log_code = log_code;
	}
	
	public int getMember_code() {
		return member_code;
	}
	
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	
	public int getTopic() {
		return topic;
	}
	
	public void setTopic(int topic) {
		this.topic = topic;
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
		builder.append("LogDTO [log_code=").append(log_code).append(", member_code=").append(member_code)
				.append(", topic=").append(topic).append(", news_code=").append(news_code).append(", viewing_time=")
				.append(viewing_time).append("]");
		return builder.toString();
	}
	
}

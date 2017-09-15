package realtimes.model.dto;

public class TopicDTO {
	private int topic;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	private String keyword5;
	public TopicDTO() {
	}
	public TopicDTO(int topic, String keyword1, String keyword2, String keyword3, String keyword4, String keyword5) {
		super();
		this.topic = topic;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
	}
	public int getTopic() {
		return topic;
	}
	public void setTopic(int topic) {
		this.topic = topic;
	}
	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	public String getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}
	public String getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}
	public String getKeyword4() {
		return keyword4;
	}
	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}
	public String getKeyword5() {
		return keyword5;
	}
	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TopicDTO [topic=").append(topic).append(", keyword1=")
				.append(keyword1).append(", keyword2=").append(keyword2).append(", keyword3=").append(keyword3)
				.append(", keyword4=").append(keyword4).append(", keyword5=").append(keyword5);
		return builder.toString();
	}
	
}

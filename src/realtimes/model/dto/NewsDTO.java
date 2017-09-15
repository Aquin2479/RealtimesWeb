package realtimes.model.dto;

public class NewsDTO {
	
	private String news_code;
	private String topic_name;
	private String section;
	private String title;
    private String writing_time; 
    private String company;
    private String img;
    private String content;
    
	public NewsDTO(String news_code, String topic_name, String section, String title, String writing_time, String company,
			String img, String content) {
		super();
		this.news_code = news_code;
		this.topic_name = topic_name;
		this.section = section;
		this.title = title;
		this.writing_time = writing_time;
		this.company = company;
		this.img = img;
		this.content = content;
	}
	
	public String getNews_code() {
		return news_code;
	}
	
	public void setNews_code(String news_code) {
		this.news_code = news_code;
	}
	
	public String getTopic_name() {
		return topic_name;
	}
	
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	
	public String getsection() {
		return section;
	}
	
	public void setsection(String section) {
		this.section = section;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriting_time() {
		return writing_time;
	}
	
	public void setWriting_time(String writing_time) {
		this.writing_time = writing_time;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NewsDTO [news_code=").append(news_code).append(", topic_name=").append(topic_name)
				.append(", section=").append(section).append(", title=").append(title).append(", writing_time=")
				.append(writing_time).append(", company=").append(company).append(", img=").append(img)
				.append(", content=").append(content).append("]");
		return builder.toString();
	}
    
}

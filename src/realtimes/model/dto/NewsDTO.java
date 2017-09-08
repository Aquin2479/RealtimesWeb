package realtimes.model.dto;

public class NewsDTO {
	
	private int news_code;
	private int topic;
	private String site;
	private String title;
    private String writing_time; 
    private String company;
    private String img;
    private String content;
    
	public NewsDTO(int news_code, int topic, String site, String title, String writing_time, String company, String img,
			String content) {
		super();
		this.news_code = news_code;
		this.topic = topic;
		this.site = site;
		this.title = title;
		this.writing_time = writing_time;
		this.company = company;
		this.img = img;
		this.content = content;
	}
	
	public int getNews_code() {
		return news_code;
	}
	
	public void setNews_code(int news_code) {
		this.news_code = news_code;
	}
	
	public int getTopic() {
		return topic;
	}
	
	public void setTopic(int topic) {
		this.topic = topic;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
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
		builder.append("NewsDTO [news_code=").append(news_code).append(", topic=").append(topic).append(", site=")
				.append(site).append(", title=").append(title).append(", writing_time=").append(writing_time)
				.append(", company=").append(company).append(", img=").append(img).append(", content=").append(content)
				.append("]");
		return builder.toString();
	}
   
}
package realtimes.model.dto;

public class TopicDTO {
	
	private int topic_code;
	private String topic_name;
	private String section;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	private String keyword5;
	private String analysis_start_time;
	private String analysis_end_time;
	private int article_count;
	
	public TopicDTO(int topic_code, String topic_name, String section, String keyword1, String keyword2,
			String keyword3, String keyword4, String keyword5, String analysis_start_time, String analysis_end_time,
			int article_count) {
		super();
		this.topic_code = topic_code;
		this.topic_name = topic_name;
		this.section = section;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
		this.analysis_start_time = analysis_start_time;
		this.analysis_end_time = analysis_end_time;
		this.article_count = article_count;
	}
	public int getTopic_code() {
		return topic_code;
	}
	public void setTopic_code(int topic_code) {
		this.topic_code = topic_code;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
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
	public String getAnalysis_start_time() {
		return analysis_start_time;
	}
	public void setAnalysis_start_time(String analysis_start_time) {
		this.analysis_start_time = analysis_start_time;
	}
	public String getAnalysis_end_time() {
		return analysis_end_time;
	}
	public void setAnalysis_end_time(String analysis_end_time) {
		this.analysis_end_time = analysis_end_time;
	}
	public int getArticle_count() {
		return article_count;
	}
	public void setArticle_count(int article_count) {
		this.article_count = article_count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TopicDTO [topic_code=").append(topic_code).append(", topic_name=").append(topic_name)
				.append(", section=").append(section).append(", keyword1=").append(keyword1).append(", keyword2=")
				.append(keyword2).append(", keyword3=").append(keyword3).append(", keyword4=").append(keyword4)
				.append(", keyword5=").append(keyword5).append(", analysis_start_time=").append(analysis_start_time)
				.append(", analysis_end_time=").append(analysis_end_time).append(", article_count=")
				.append(article_count).append("]");
		return builder.toString();
	}
	
}

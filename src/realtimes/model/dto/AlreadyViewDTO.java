package realtimes.model.dto;

public class AlreadyViewDTO {
	private String site;

	public AlreadyViewDTO() {
	}

	public AlreadyViewDTO(String site) {
		this.site = site;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlreadyViewDTO [site=").append(site);
		return builder.toString();
	}
	
}

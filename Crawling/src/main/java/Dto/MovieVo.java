package Dto;

import java.io.Serializable;

public class MovieVo implements Serializable{

	private String title;
	private Double percent;
	
	public MovieVo() {}

	public MovieVo(String title, Double percent) {
		this.title = title;
		this.percent = percent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "MovieVo [title=" + title + ", percent=" + percent + "]";
	}
	
}

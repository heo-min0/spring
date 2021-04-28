package bit.com.a.dto;

import java.io.Serializable;

public class YoutubeDto implements Serializable{
	
	private int seq;
	private String id, title, url, wdate;
	
	public YoutubeDto() {}

	public YoutubeDto(int seq, String id, String title, String url, String wdate) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.url = url;
		this.wdate = wdate;
	}

	public YoutubeDto(String id, String title, String url) {
		this.id = id;
		this.title = title;
		this.url = url;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "YoutubeDto [seq=" + seq + ", id=" + id + ", title=" + title + ", url=" + url + ", wdate=" + wdate + "]";
	}
	
}

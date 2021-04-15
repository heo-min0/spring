package bit.com.a.dto;

import java.io.Serializable;

public class BbsParam implements Serializable{
	private String s_category, keyword;
	private int page;
	
	public BbsParam() {
	}

	public BbsParam(String s_category, String keyword, int page) {
		super();
		this.s_category = s_category;
		this.keyword = keyword;
		this.page = page;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BbsParam [s_category=" + s_category + ", keyword=" + keyword + ", page=" + page + "]";
	}


}

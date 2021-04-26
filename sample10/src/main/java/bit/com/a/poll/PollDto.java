package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

//투표 주제(질의)
public class PollDto implements Serializable {

	private int pollid; //투표번호(시퀀스)
	private String id, question; //투표 만든 사람,	투표 질문
	private Date sdate, edate, regdate; //투표 시작, 종료일, 만든날
	
	private int itemcount, polltotal; //보기수 2~10, 이 항목에 투표한 사람 수
	
	private boolean vote; //투표를 했는지 안했는지 조사하는
	
	public PollDto() {}

	public PollDto(int pollid, String id, String question, Date sdate, Date edate, Date regdate, int itemcount,	int polltotal, boolean vote) {
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.regdate = regdate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.vote = vote;
	}

	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPolltotal() {
		return polltotal;
	}

	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "PollDto [pollid=" + pollid + ", id=" + id + ", question=" + question + ", sdate=" + sdate + ", edate="
				+ edate + ", regdate=" + regdate + ", itemcount=" + itemcount + ", polltotal=" + polltotal + ", vote="
				+ vote + "]";
	}
	
}

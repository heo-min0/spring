package bit.com.a.poll;

import java.io.Serializable;
import java.util.Date;

//투표자
public class Voter implements Serializable {

	private int voterid, pollid, pollsubid; //단순 번호, 투표 질의, 투표 보기
	private String id; //누구?
	private Date regdate; //언제
	
	public Voter() {}

	public Voter(int voterid, int pollid, int pollsubid, String id, Date regdate) {
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}

	public Voter(int pollid, int pollsubid, String id) {
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
	}

	public int getVoterid() {
		return voterid;
	}

	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Voter [voterid=" + voterid + ", pollid=" + pollid + ", pollsubid=" + pollsubid + ", id=" + id
				+ ", regdate=" + regdate + "]";
	}
	
}

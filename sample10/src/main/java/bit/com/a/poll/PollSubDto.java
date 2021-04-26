package bit.com.a.poll;

import java.io.Serializable;

//투표 보기들
public class PollSubDto implements Serializable {

	private int pollsubid, pollid; //보기번호, 투표번호(외래키)
	private String answer; // 보기명 : 사과, 배 바나나 등
	private int acount; //이 보기를 선택한 사람 수(통계용)
	
	public PollSubDto() {}

	public PollSubDto(int pollsubid, int pollid, String answer, int acount) {
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	@Override
	public String toString() {
		return "PollSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", acount=" + acount
				+ "]";
	}
	
}

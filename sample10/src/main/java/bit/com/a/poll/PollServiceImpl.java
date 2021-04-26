package bit.com.a.poll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	PollDao dao;

	@Override
	public List<PollDto> getPollAllList(String id) {
		//모든 투표 목록을 갖고 옴
		List<PollDto> list = dao.getPollAllList();
		
		//편집을 해서 투표가 가능한지 설정해서 넘겨줄 목록
		List<PollDto> plist = new ArrayList<PollDto>();
		
		for (PollDto poll : list) {
			int pollid = poll.getPollid(); //투표번호를 꺼냄
			
			//1:투표한거 0:투표 안한거
			int count = dao.isVote(new Voter(pollid,-1,id));
			
			if(count == 1) {  poll.setVote(true); }
			else { poll.setVote(false); }
			
			plist.add(poll);
		}
		return plist;
	}

	@Override
	public void makePoll(PollBean pbean) {
		//투표주제
		PollDto poll = new PollDto(pbean.getId(),
								   pbean.getQuestion(),
								   pbean.getSdate(), 
								   pbean.getEdate(), 
								   pbean.getItemcount(),
								   0);
		System.out.println(poll.toString());
		dao.makePoll(poll);
		
		//투표보기들
		String answer[] = pbean.getPollnum();
		
		for (int i=0; i<pbean.getItemcount(); i++) {
			PollSubDto pollsub = new PollSubDto();
			pollsub.setAnswer(answer[i]);
			
			dao.makePollSub(pollsub);
		}
	}

	@Override
	public PollDto getPoll(PollDto poll) {
		return dao.getPoll(poll);
	}

	@Override
	public List<PollSubDto> getPollSubList(PollDto poll) {
		return dao.getPollSubList(poll);
	}

	@Override
	public void polling(Voter voter) {
		dao.pollingVoter(voter);
		dao.pollingPoll(voter);
		dao.pollingSub(voter);
	}
	
	
}

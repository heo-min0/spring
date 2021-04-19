package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	public int getId(MemberDto mem) {
		return memberDao.getId(mem);
	}

	@Override
	public int addMember(MemberDto mem) {
		return memberDao.addMember(mem);
	}

	@Override
	public MemberDto login(MemberDto mem) {
		// TODO Auto-generated method stub
		return memberDao.login(mem);
	}

}

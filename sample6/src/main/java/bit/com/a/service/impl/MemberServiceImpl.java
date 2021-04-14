package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;

	@Override
	public String getMember(String id) {
		String b = "";
		int a = memberDao.getMember(id);
		b = a>0?"no":"yes";
		return b;
	}

	@Override
	public int addMember(MemberDto dto) {
		return memberDao.addMember(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}
	
	
}

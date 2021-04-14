package bit.com.a.service;

import bit.com.a.dto.MemberDto;

public interface MemberService {
	String getMember(String id);
	int addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}

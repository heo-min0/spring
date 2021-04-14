package bit.com.a.dao;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	int getMember(String id);
	int addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}

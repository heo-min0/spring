package bit.com.a.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	@Override
	public int getMember(String id) {
		int a = sqlSession.selectOne(namespace + "getmember", id);
		return a;
	}

	@Override
	public int addMember(MemberDto dto) {
		int count = sqlSession.insert(namespace+ "addmember", dto);
		return count;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto mem = sqlSession.selectOne(namespace + "login", dto);
		return mem;
	}
	
}

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
	public int getId(MemberDto mem) {
		return sqlSession.selectOne(namespace + "getId", mem);
	}

	@Override
	public int addMember(MemberDto mem) {
		return sqlSession.insert(namespace + "addmember", mem);
	}

	@Override
	public MemberDto login(MemberDto mem) {
		return sqlSession.selectOne(namespace + "login", mem);
	}

}

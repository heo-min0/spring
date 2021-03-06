package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession sqlSession; //ibatis 2.3 이전
	//SqlSessionTemplate session; //mybatis 2.5 이후
	
	String namespace = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList(BbsParam bbs) {
		return sqlSession.selectList(namespace+"bbslist",bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {
		return sqlSession.selectOne(namespace+"getBbsCount",bbs);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		int a = sqlSession.insert(namespace+"writeBbs",dto);
		return a>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {
		return sqlSession.selectOne(namespace+"getBbs",seq);
	}

	@Override
	public void updateBbs(BbsDto bbs) {
		sqlSession.update(namespace+"updateBbs",bbs);
	}

	@Override
	public void deleteBbs(int seq) {
		sqlSession.update(namespace+"deleteBbs",seq);
	}

	@Override
	public boolean replyBbsUpdate(BbsDto bbs) {
		int a = sqlSession.update(namespace+"replyBbsUpdate",bbs);
		return a>0?true:false;
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) {
		int a = sqlSession.insert(namespace+"replyBbsInsert",bbs);
		return a>0?true:false;
	}

	@Override
	public void readCount(int seq) {
		sqlSession.update(namespace+"readCount",seq);
	}

}

package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession sqlSession;
	String ns = "Bbs.";
	
	@Override
	public List<BbsDto> getBbsList() {
		return sqlSession.selectList(ns + "bbslist");
	}

	@Override
	public List<BbsDto> getBbsList(BbsParam p) {
		return sqlSession.selectList(ns + "pagebbslist", p);
	}

	@Override
	public int getBbspage(BbsParam p) {
		return sqlSession.selectOne(ns + "pageallbbs", p);
	}

	@Override
	public int writeBbs(BbsDto dto) {
		return sqlSession.insert(ns + "bbswrite", dto);
	}

	@Override
	public BbsDto bbsdetail(BbsDto dto) {
		return sqlSession.selectOne(ns + "bbsdetail", dto);
	}

	@Override
	public int bbsAnswer(BbsDto dto) {
		int a = sqlSession.update(ns + "answerup", dto);
		int b = sqlSession.insert(ns + "answerin", dto);
		return b;
	}

	@Override
	public int bbsUpdate(BbsDto dto) {
		return sqlSession.update(ns + "bbsupdate", dto);
	}

	@Override
	public int bbsDel(BbsDto dto) {
		return sqlSession.update(ns + "bbsdel", dto);
	}

	@Override
	public void readCount(BbsDto dto) {
		sqlSession.update(ns + "readcount", dto);
	}

}

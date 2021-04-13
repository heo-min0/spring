package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession sqlSession;
	String namespace = "Bbs.";
	
	@Override
	public List<BbsDto> allBbs() {
		List<BbsDto> list = sqlSession.selectList(namespace+ "allBbs");
		return list;
	}

}

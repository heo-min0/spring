package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;

@Repository
public class PdsDaoImpl implements PdsDao {

	@Autowired
	SqlSession session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> getPdsList() {
		return session.selectList(ns+"getPdsList");
	}

	@Override
	public boolean uploadPds(PdsDto dto) {
		int i = session.insert(ns+"uploadPds",dto);
		return i>0?true:false;
	}

	@Override
	public PdsDto getPds(int seq) {
		return session.selectOne(ns+"getPds",seq);
	}

	@Override
	public int delPds(int seq) {
		return session.update(ns+"delPds",seq);
	}

	@Override
	public int updatePds(PdsDto dto) {
		return session.update(ns+"updatePds",dto);
	}
	
	
}

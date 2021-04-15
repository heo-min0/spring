package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao bbsDao;
	
	@Override
	public List<BbsDto> getBbsList() {
		return bbsDao.getBbsList();
	}

	@Override
	public List<BbsDto> getBbsList(BbsParam p) {
		return bbsDao.getBbsList(p);
	}

	@Override
	public int getBbspage(BbsParam p) {
		int len = bbsDao.getBbspage(p);
		int slen = len/10;
		if(len%10 > 0) slen += 1; 
		return slen;
	}

	@Override
	public int writeBbs(BbsDto dto) {
		return bbsDao.writeBbs(dto);
	}

	@Override
	public BbsDto bbsdetail(BbsDto dto) {
		return bbsDao.bbsdetail(dto);
	}

	@Override
	public int bbsAnswer(BbsDto dto) {
		return bbsDao.bbsAnswer(dto);
	}

	@Override
	public int bbsUpdate(BbsDto dto) {
		return bbsDao.bbsUpdate(dto);
	}

	@Override
	public int bbsDel(BbsDto dto) {
		return bbsDao.bbsDel(dto);
	}

	@Override
	public void readCount(BbsDto dto) {
		bbsDao.readCount(dto);
	}

}

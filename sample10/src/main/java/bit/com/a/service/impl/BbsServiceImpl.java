package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao bbsDao;
	
	@Override
	public List<BbsDto> getBbsList(BbsParam bbs) {
		return bbsDao.getBbsList(bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {
		return bbsDao.getBbsCount(bbs);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		return bbsDao.writeBbs(dto);
	}

	@Override
	public BbsDto getBbs(int seq) {
		return bbsDao.getBbs(seq);
	}

	@Override
	public void updateBbs(BbsDto bbs) {
		bbsDao.updateBbs(bbs);
	}

	@Override
	public void deleteBbs(int seq) {
		bbsDao.deleteBbs(seq);
	}

	@Override
	public void reply(BbsDto bbs) {
		bbsDao.replyBbsUpdate(bbs);
		bbsDao.replyBbsInsert(bbs);
	}

	@Override
	public void readCount(int seq) {
		bbsDao.readCount(seq);
	}

}

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

}
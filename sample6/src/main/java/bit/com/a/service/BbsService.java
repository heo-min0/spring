package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {
	List<BbsDto> getBbsList();
	List<BbsDto> getBbsList(BbsParam p);
	int getBbspage(BbsParam p);
	int writeBbs(BbsDto dto);
	BbsDto bbsdetail(BbsDto dto);
	int bbsAnswer(BbsDto dto);
	int bbsUpdate(BbsDto dto);
	int bbsDel(BbsDto dto);
	void readCount(BbsDto dto);
}

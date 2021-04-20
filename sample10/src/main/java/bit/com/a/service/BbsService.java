package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getBbsList(BbsParam bbs);	
	int getBbsCount(BbsParam bbs);
	
	boolean writeBbs(BbsDto dto);
	
	BbsDto getBbs(int seq);
	void updateBbs(BbsDto bbs);
	void deleteBbs(int seq);
	
	void reply(BbsDto bbs);		// <- 여기서 update와 insert를 모두 호출

	void readCount(int seq);
	
	
}

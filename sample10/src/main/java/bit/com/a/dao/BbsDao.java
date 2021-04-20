package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {

	List<BbsDto> getBbsList(BbsParam bbs);	
	int getBbsCount(BbsParam bbs);
	
	boolean writeBbs(BbsDto dto);
	
	BbsDto getBbs(int seq);
	void updateBbs(BbsDto bbs);
	void deleteBbs(int seq);

	boolean replyBbsUpdate(BbsDto bbs);
	boolean replyBbsInsert(BbsDto bbs);
		
	void readCount(int seq);
	
}

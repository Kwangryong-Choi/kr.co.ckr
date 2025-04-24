package kr.co.ckrjjang;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Component : @Controller, @Service, @Repository 모두 포함한 어노테이션
// @Service : 클래스를 해당 코드 로직에 정보를 담고 있는 어노테이션이며, interface를 호출 시 작동되는 클래스를 말함  =?  class파일에서 사용  =>  @Autowired로 호출해야 함

@Service
public class membership_dao implements membership_service {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private mapper mp;	//Mapper를 로드하여 SQL Query문을 실행
	
	// selectList, selectone, insert, delete, update (x)
	@Override
	public List<membership_dto> alldata() {
		List<membership_dto> all = this.mp.alldata();
		this.log.atInfo();
		this.log.info(all.toString());
		return all;
	}
	
	@Override
	public int join_member(membership_dto dto) {
		int result = this.mp.save_member(dto);
		return result;
	}

}

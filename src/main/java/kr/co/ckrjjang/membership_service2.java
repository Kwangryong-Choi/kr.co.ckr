package kr.co.ckrjjang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository => Controller @Resource로 로드 하여 실행시킬 수 있음
//JPA => @Service 위주로 사용합니다.
//JPA => @Repository 무조건 사용하고 싶을 경우 class extends 하여 제공함
@Service
@Repository("membership_service2")
public class membership_service2 {

	@Autowired
	private mapper mp;
	
	//사용자 아이디에 맞는 데이터 한개의 값 가져오는 메소드
	public List<membership_dto> onedate(String MID){
		List<membership_dto> one = this.mp.onedate(MID);
		return one;		
	}
	
}

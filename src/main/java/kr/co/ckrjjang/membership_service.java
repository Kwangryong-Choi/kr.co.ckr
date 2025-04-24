package kr.co.ckrjjang;

import java.util.List;
//@Service에서는 
//해당 class에서 @Override 메소드를 실행함 => @Controller에서 interface 로드 
public interface membership_service {
	List<membership_dto> alldata();
	int join_member(membership_dto dto);
}

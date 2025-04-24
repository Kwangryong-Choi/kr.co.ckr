package kr.co.ckrjjang;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//Mapper => 무조건 interface 임
@Mapper
public interface mapper {
	List<membership_dto> onedate(String MID);	//하나의 데이터
	List<membership_dto> alldata();
	int save_member(membership_dto dto);
}

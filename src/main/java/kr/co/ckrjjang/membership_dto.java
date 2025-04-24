package kr.co.ckrjjang;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("membership_dto")
public class membership_dto {
	Integer MIDX, MCODE;
	String MID,MNAME,MNICK,MPASS,MEMAIL,MHP,MJOIN,MDATE;
}

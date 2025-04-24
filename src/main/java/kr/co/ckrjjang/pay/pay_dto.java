package kr.co.ckrjjang.pay;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("pay_dto")
public class pay_dto {
	
	String goodcode, goodname, goodea, goodprice;
	
	// 상품코드, 상품명, 상품금액, 상품수량, 결제금액
	String product_code, product_nm, product_money, product_ea, price;
	// 고객명, 고객연락처, 이메일, 우편번호, 도로명주소, 도로명 상세주소, 결제방식
	String buyername, buyertel, buyeremail, rec_post, rec_way, rec_addr;
	String gopaymethod;
}

document.querySelector("#btn").addEventListener("click",function(){
		new memberjoin().input_check();	
});

export class memberjoin{

	input_check(){
		if(frm.MID.value==""){
			alert("아이디를 입력하세요");
		}
		else if(frm.MPASS.value==""){
			alert("패스워드를 입력하세요");
		}
		else{
			frm.submit();	
		}
		
	}
	
}
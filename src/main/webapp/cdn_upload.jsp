<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
CDN : 콘텐츠 전송 네트워크 서비스를 말합니다.  
CDN Server에는 이미지, 동영상, 문서파일 외에는 업로드 하지 않음 
(.html, .jsp, .htm, .js, .css (X))

CDN Server : E-러닝, 영상관련 (스트리밍 서비스)
쇼핑몰, 상품판매 site일 경우 CDN Sever => 배너, 각종 아이콘, 상품이미지...
-->
<title>CDN Server에 파일전송</title>
</head>
<body>
<form id="frm" method="post" action="./cdn_uploadok.do" enctype="multipart/form-data">
CDN 파일전송 : <input type="file" name="mfile"><br>
<input type="button" value="전송" onclick="fileok()">
</form>
</body>
<script>
function fileok(){
	frm.submit();
}
</script>

</html>
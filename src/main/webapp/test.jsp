<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date today = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bootstrap 회원가입 + Spring-boot</title>
<link rel="stylesheet" href="./css/bootstrap.css?v=<%=today%>">
<script src="./js/bootstrap.js"></script>
</head>
<body>
<form id="frm" method="post" action="./join.do">
<input type="hidden" name="MCODE" value="1">
<input type="hidden" name="MJOIN" value="WEB">
<div class="mb-3">
  <label class="form-label">회원아이디</label>
  <input type="text" name="MID" class="form-control width1" placeholder="아이디를 입력하세요!">
</div>
<div class="mb-3">
  <label class="form-label">패스워드</label>
  <input type="password" name="MPASS" class="form-control width1" placeholder="패스워드를 입력하세요!">
</div>
<div class="mb-3">
  <label class="form-label">고객명</label>
  <input type="text" name="MNAME" class="form-control width1" placeholder="고객명을 입력하세요!">
</div>
<div class="mb-3">
  <label class="form-label">별명</label>
  <input type="text" name="MNICK" class="form-control width1" placeholder="별명을 입력하세요!">
</div>
<div class="mb-3">
  <label class="form-label">이메일</label>
  <input type="text" name="MEMAIL" class="form-control width1" placeholder="이메일을 입력하세요!">
</div>
<div class="mb-3">
  <label class="form-label">연락처</label>
  <input type="text" name="MHP" class="form-control width1" placeholder="'-'빼고 숫자만 입력하세요">
</div>
<div class="mb-3">
<button type="button" id="btn" class="btn btn-hotpink width1">회원가입</button>
</div>
</form>
<script type="module">
import {memberjoin} from "./test.js?v=<%=today%>";
</script>
</body>
</html>
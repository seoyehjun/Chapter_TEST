<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form action="update/${user.idx }" method="POST">
	<section class="board half">
		<table>
			<tr>
				<th>회원번호</th>
				<td>${user.idx }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.userid }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input name="userpw" type="password" required></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${user.nick }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${user.join_date }</td>
			</tr>
		</table>
		
		<br>
		
		<button>수정</button>
		
		<a href="${cpath }/acc/delete/${user.idx }">
			<button type="button">탈퇴</button>
		</a>
	</section>
</form>
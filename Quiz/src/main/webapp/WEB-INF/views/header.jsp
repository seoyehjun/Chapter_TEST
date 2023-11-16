<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${capth }</title>
<link href="${cpath }/resources/css/style.css" rel="stylesheet">
</head>
<body>
<header>
	<h1>Quiz</h1>
	
	<nav class="menu">
		<ul>
			<li><a href="${cpath }">home</a></li>
			<c:if test="${empty user }">
				<li><a href="${cpath }/acc/signUp">signUp</a></li>
				<li><a href="${cpath }/acc/login">Login</a></li>
			</c:if>
			<c:if test="${not empty user }">
				<li><a href="${cpath }/acc/myPage">${user.nick }</a></li>
				<li><a href="${cpath }/acc/logout">Logout</a></li>
			</c:if>
		</ul>
	</nav>
</header>

<hr>

<main>
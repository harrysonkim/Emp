<%@page import="dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Emp emp = (Emp) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script></head>
</head>
<body class="container">

<h1>사원 상세조회</h1>
<hr>
<table class="table table-striped text-center">

<thead class="container text ">
<tr class="table-dark">
	<th class="col-1">사번</th>
	<th class="col-1">사원이름</th>
	<th class="col-2">직무</th>
	<th class="col-1">담당자</th>
	<th class="col-2">입사날짜</th>
	<th class="col-1">급여</th>
	<th class="col-1">상여금</th>
	<th class="col-1">부서</th>
</tr>
</thead>

<tbody>
<tr>
	<td><%= emp.getEmpno() %></td>
	<td><%= emp.getEname() %></td>
	<td><%= emp.getJob() %></td>
	<td><%= emp.getMgr() %></td>
	<td><%= emp.getHiredate() %></td>
	<td><%= emp.getSal() %></td>
	<td><%= emp.getComm() %></td>
	<td><%= emp.getDeptno() %></td>
</tr>
</tbody>


</table>
<a href="/emp/list">
	<button>목록</button>
</a>	
</body>
</html>
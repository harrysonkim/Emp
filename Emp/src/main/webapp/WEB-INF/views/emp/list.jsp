<%@page import="dto.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP 주석 --%>
<%-- JSP파일에서 자바 코드를 작성할 수 있게 해준다 --%>
<%
// JSP 태그
%>


<%
// 서블릿(Controller)이 forward방식으로 전달한 데이터 꺼내기
	List<Emp> empList = (List<Emp>) request.getAttribute("eList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script></head>
<body>

<div class="container">
<h1>사원 목록</h1>
<hr>

<table class="table table-striped text-center">

<thead class="container text ">
<tr class="table-dark">
	<th class="col-5">사번</th>
	<th class="col-5">사원이름</th>
</tr>
</thead>

<tbody>
<% for(int i=0; i < empList.size(); i++){ %>

<tr>
	<td><%= empList.get(i).getEmpno() %></td>
	
	<td>
		<a href="/emp/detail?eno=<%= empList.get(i).getEmpno() %>">
			<%= empList.get(i).getEname() %>
		</a>
	</td>
</tr>

<% } %>
</tbody>
</table>

</div>
</body>
</html>
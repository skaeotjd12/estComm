<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	wdwdwd
<div class="indexContainer">
<c:forEach var="dto" items="${memView}">
  <h1>${dto.MBR_ID}</h1>
</c:forEach>
</div>

</body>
</html>
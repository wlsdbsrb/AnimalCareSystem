<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>동물 정보 조회</title>
</head>
<body>
<h1>동물 정보</h1>
<table border="1">
    <thead>
    <th>이름</th>
    <th>생년월일</th>
    <th>종류</th>
    <th>품종</th>
    <th>주인이름</th>
    <th>주인전화번호</th>
    </thead>
    <c:forEach var="item" items="${animals}">
        <tr>
            <td>${item.aniName}</td>
            <td>${item.birth}</td>
            <td>${item.type}</td>
            <td>${item.kind}</td>
            <td>${item.master}</td>
            <td>${item.phone}</td>
        </tr>
    </c:forEach>
</table>
<a href="/main.jsp">메인</a>
</body>
</html>
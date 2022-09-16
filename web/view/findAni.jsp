<%--
  Created by IntelliJ IDEA.
  User: 진윤규
  Date: 2022-09-04
  Time: 오후 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script>
    function search(aniName) {
        if (aniName.keyword.value == "") {
            alert("단어를 입력하세요.");
            aniName.keyword.focus();
            return;
        }
        aniName.submit();
    }
</script>
<body>
<h1>동물 정보</h1>
<a href="/main.jsp">메인</a>
<form action = "/servlet/animal/info" method = "post">
    <br><input type="submit" value="조회"/>
    동물이름정렬 : <input type="radio" name = "Type" value="동물정렬" />
    주인이름정렬 : <input type="radio" name = "Type" value="주인정렬" /> <br/>
    <input type ="hidden" name = "Type" value="기본정렬" />
</form>
<table border="1">
    <thead>
    <th>이름</th>
    <th>생년월일</th>
    <th>종류</th>
    <th>품종</th>
    <th>주인이름</th>
    <th>주인전화번호</th>

    </thead>
    <c:forEach var="item" items="${animalList}">
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
<tr>
    <td colspan="10"><br/>
        <form method="post" action="find">
            <select name="keyfield">
                <option value="name">이름</option>
            </select>
            <input type="text" name="keyword"/>
            <input type="button" value="검색" onclick="search(form)">
        </form>
    </td>
</tr>
</body>
</html>


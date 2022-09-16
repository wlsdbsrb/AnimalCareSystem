<%--
  Created by IntelliJ IDEA.
  User: 진윤규
  Date: 2022-09-04
  Time: 오후 6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="insert" method="post">
    <table>
        <tr>
            <td>이름 :</td>
            <td><input type="text" name="aniName" maxlength="20"/></td>
        </tr>
        <tr>
            <td>생년월일 :</td>
            <td><input type="text" name="birth" maxlength="20"/></td>
        </tr>
        <tr>
            <td>종류 :</td>
            <td><input type="text" name="type" maxlength="20"/></td>
        </tr>
        <tr>
            <td>품종 :</td>
            <td><input type="text" name="kind" maxlength="20"/></td>
        </tr>
        <tr>
            <td>주인이름 :</td>
            <td><input type="text" name="master" maxlength="20"/></td>
        </tr>
        <tr>
            <td>주인전화번호 :</td>
            <td><input type="text" name="phone" maxlength="20"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit">등록</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

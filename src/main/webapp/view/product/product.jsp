<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 8/8/2025
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Danh sách </h1>
<a href="/product?action=create">Thêm sản phẩm mới</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Mo ta</th>
        <th>nha san xuat</th>
    </tr>
    <c:forEach var="p" items="${productList}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.productor}</td>
        </tr>
    </c:forEach>
</table>



</body>
</html>

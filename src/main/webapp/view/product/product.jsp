<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<a href="/product?action=create">Thêm sản phẩm mới</a>

<form action="/product" method="post" style="margin-top:10px;">
    <input type="hidden" name="action" value="search">
    <input type="text" name="keyword" placeholder="Tìm theo tên">
    <input type="submit" value="Tìm kiếm">
</form>

<table border="1" cellpadding="5" cellspacing="0" style="margin-top:10px;">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Mô tả</th>
        <th>Nhà sản xuất</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="p" items="${productList}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.productor}</td>
            <td>
                <a href="/product?action=edit&id=${p.id}" style ="color: aqua" >Edit</a> |
                <a href="/product?action=delete&id=${p.id}" onclick="return confirm('Bạn có chắc muốn xóa?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>



</body>
</html>

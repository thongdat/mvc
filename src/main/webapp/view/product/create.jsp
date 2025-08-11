<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 8/8/2025
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<h1>Thêm sản phẩm mới</h1>
<form method="post" action="/product?action=create">
    <label>Mã SP:</label>
    <input type="text" name="id" required><br><br>
    <label>Tên SP:</label>
    <input type="text" name="name" required><br><br>
    <label>Giá:</label>
    <input type="number" step="0.01" name="price" required><br><br>
    <label>Mô tả:</label>
    <input type="text" name="description"><br><br>
    <label>Nhà sản xuất:</label>
    <input type="text" name="productor"><br><br>
    <button type="submit">Lưu</button>
</form>
</body>
</html>


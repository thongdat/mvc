<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<form action="/product" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${product.id}">
    Name: <input type="text" name="name" value="${product.name}"><br>
    Price: <input type="text" name="price" value="${product.price}"><br>
    Description: <input type="text" name="description" value="${product.description}"><br>
    Manufacturer: <input type="text" name="productor" value="${product.productor}</td>
}"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>


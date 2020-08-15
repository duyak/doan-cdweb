<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 07/08/2020
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/theme1/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<%--<table class="table">--%>
<%--    <tr>--%>
<%--        <th>Ma Dong san pham</th>--%>
<%--        <th>Dong san pham</th>--%>
<%--        <th>Nha San Xuat</th>--%>

<%--    </tr>--%>
<%--    <c:forEach var="productline" items="${productlines}">--%>
<%--        <tr>--%>
<%--            <td>${productline.id}</td>--%>
<%--            <td>${productline.name}</td>--%>
<%--            <td>${productline.brandId.name}</td>--%>

<%--        </tr>--%>
<%--        <select name="" id="">--%>
<%--            <option value="${productline.name}"></option>--%>
<%--        </select>--%>

<%--    </c:forEach>--%>
<%--    --%>
<%--</table>--%>
<div>

   Nha San Xuat: <select name="" id="">
        <c:forEach var="productline" items="${productlines}">
        <option value="${productline.id}">${productline.name}</option>
        </c:forEach>
    </select>

</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

欢迎你${username}

<script>
    function toAdd(){
        window.location.href="addBrand.jsp";
    }
</script>
<input type="button" value="新增" onclick="toAdd()"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <c:forEach items="${brands}" var="brand" >
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status!=1}">
                <td>禁用</td>
            </c:if>
            <td><a href="<c:url value="/selectByIdServlet?id=${brand.id}"/>">修改</a> <a href="<c:url value="/deleteBrandServlet?id=${brand.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
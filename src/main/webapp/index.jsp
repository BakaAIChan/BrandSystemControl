<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>login</title>
  <link href="css/login.css" rel="stylesheet">
</head>

<body onload="checkUser()">
<div id="loginDiv" style="height: 350px">
  <form action="<c:url value="/loginServlet"/>" id="form" method="post">
    <h1 id="loginMsg">LOGIN IN</h1>
    <div id="errorMsg">${login_esm}</div>
    <p>Username:<input id="username" name="username" type="text" value="<%
          Cookie[] cookies1 = request.getCookies();
          if(cookies1!=null){
            for (Cookie c : cookies1) {
              if("un".equals(c.getName())){
                out.println(c.getValue());
                break;
              }
          }
          }
     %>"></p>
    <p>Password:<input id="password" name="password" type="password" value="<%
          Cookie[] cookies2 = request.getCookies();
          if(cookies2!=null){
            for (Cookie c : cookies1) {
              if("pw".equals(c.getName())){
                out.println(c.getValue());
                break;
              }
          }
          }

     %>"></p>
    <p>Remember:<input id="remember" name="remember" type="checkbox"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="login up">
      <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
      <a href="register.jsp">没有账号？</a>
    </div>
  </form>
</div>
</body>
</html>
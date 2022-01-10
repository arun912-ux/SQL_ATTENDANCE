<%--
  Created by IntelliJ IDEA.
  User: ARUN S
  Date: 15-Dec, 015
  Time: 01:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
<%--    <link rel="stylesheet" href="insert.css">--%>
</head>
<body>
    <h2 align="center">Insert</h2>

    <div id="formdiv" align="center">
        <form action="helloServlet/newemployee" method="post">
            <label for="id">ID : </label><input type="text" id="id" name="id"> <br/>
            <label for="name">Name : </label><input type="text" id="name" name="name"> <br/>
            <label for="age">Age : </label><input type="text" id="age" name="age"> <br/>
            <label for="sal">Salary : </label><input type="text" id="sal" name="sal"><br/>
            <input type="submit"><br/>
        </form>
    </div>

    <div id="Home" align="center">
        <a href="http://localhost:8081/UsersTableDemo_war_exploded/index.html">Home</a>
    </div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ARUN S
  Date: 15-Dec, 015
  Time: 02:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove</title>
<%--    <link rel="stylesheet" href="remove.css">--%>
</head>
<body>

    <div id="container" align="center">
        <h2 align="center">Remove</h2>

        <div id="formdiv" align="center">

            <form action="helloServlet/removeemployee" id="form" method="post">
                <label for="id">ID : </label><input type="text" id="id" name="id"> <br/>
                <input type="submit" value="Remove">
            </form>

        </div>

        <div id="Home" align="center">
            <a href="http://localhost:8081/UsersTableDemo_war_exploded/index.html">Home</a>
        </div>
    </div>




</body>
</html>

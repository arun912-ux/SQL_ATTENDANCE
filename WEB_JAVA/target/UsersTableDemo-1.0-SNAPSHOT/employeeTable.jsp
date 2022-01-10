
<%@ page import="com.example.bean.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tables</title>
<%--    <link rel="stylesheet" type="text/css" href="table.css">--%>
</head>
<body>



    <H2 id="heading" align="center">Employee Table</H2>

    <%
        List<Employee> list = (List<Employee>) request.getAttribute("resultset");
        out.print("<div id=\"container\" align=\"center\">");
        out.print("<table>");

        out.print("<tr>");
        out.print("<th>ID<th/>");
        out.print("<th>Name<th/>");
        out.print("<th>Age<th/>");
        out.print("<th>Salary<th/>");
        out.print("<tr/>");

        try {
            for(Employee e : list){

                out.print("<tr>");
                    out.print("<td>" + e.getId() + "<td/>");
                    out.print("<td>" + e.getName() + "<td/>");
                    out.print("<td>" + e.getAge() + "<td/>");
                    out.print("<td>" + e.getSalary() + "<td/>");
                out.print("<tr/>");

            }

        }catch (Exception e){
            out.print(e);
        }
        out.print("<table/>");
        out.print("<div/>");

        out.println("<a href=\"http://localhost:8081/UsersTableDemo_war_exploded/index.html\">Home</a>");


    %>





</body>
</html>
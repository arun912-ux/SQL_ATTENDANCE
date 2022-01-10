package com.example.control;

import com.example.bean.Employee;
import com.example.dao.BeanDao;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Controller {

    BeanDao dao = new BeanDao();

    public void insertInto(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<div align=\"center\">");

        System.out.println("Inserting...");

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        int age = Integer.parseInt(req.getParameter("age"));
        String name = req.getParameter("name");
        int sal = Integer.parseInt(req.getParameter("sal"));

        Employee e = new Employee(id, name, age, sal);
        System.out.println("Calling DAO");
        String retStr = dao.insertEmployee(e);
        int ret = Integer.parseInt(retStr.substring(0,1));

        if(ret!=0){
            out.println("<H2>Employee added</H2>");
            out.println("<H2>" + retStr.substring(1) + "</H2>");

        }else {
            out.println("<H2>Employee not added</H2>");
        }

        out.println("<a href=\"http://localhost:8081/UsersTableDemo_war_exploded/index.html\">Home</a>");
        out.println("</div>");
        out.println("</body></html>");


    }


    public void removeFrom(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("Removing");
        out.println("<html><body>");
        out.println("<div align=\"center\">");

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id : " + id);
        String retStr = dao.removeEmployee(id);
        int ret = Integer.parseInt(retStr.substring(0,1));
        String removedEmployee = retStr.substring(1);

        if(ret!=0){
            out.print("<h2>Employee removed</h2>");
        }else{
            out.print("<h2>Employee not removed</h2>");
        }

        out.print("<h3>" + removedEmployee + "</h3>");

        out.println("<a href=\"http://localhost:8081/UsersTableDemo_war_exploded/index.html\">Home</a>");
        out.println("</div>");
        out.println("</body></html>");


    }

    




}

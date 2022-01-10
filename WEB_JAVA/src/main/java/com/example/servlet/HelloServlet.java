package com.example.servlet;


import com.example.bean.Employee;
import com.example.control.Controller;
import com.example.dao.BeanDao;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/helloServlet/*")
public class HelloServlet extends HttpServlet {

    BeanDao dao = new BeanDao();
    Controller control = new Controller();


    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String url = request.getRequestURI();
        System.out.println(url);

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print("<p>" + url + "</p>");


        if(url.contains("alltables")){

            List<Employee> list = dao.getAllTables();
            request.setAttribute("resultset", list);
            request.getRequestDispatcher("/employeeTable.jsp").forward(request, response);
            list.clear();

        }else if(url.contains("insert")){
            request.getRequestDispatcher("/insert.jsp").forward(request, response);

        }else if(url.contains("remove")){
            request.getRequestDispatcher("/remove.jsp").forward(request, response);

        }


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        response.setContentType("text/html");

//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");

        System.out.println("url: " + request.getRequestURI());
        String url = request.getRequestURI();

        // dao class to manipulate dB
        System.out.println(url);


        if(url.contains("newemployee")){
            control.insertInto(request, response);
        }
        if (url.contains("removeemployee")){
            control.removeFrom(request, response);
        }


//        if(url.contains("newemployee")){
//
//            System.out.println("Inserting....");
//
//            int id = Integer.parseInt(request.getParameter("id"));
//            int age = Integer.parseInt(request.getParameter("age"));
//            String name = request.getParameter("name");
//            int sal = Integer.parseInt(request.getParameter("sal"));
//
//            Employee e = new Employee(id, name, age, sal);
//            System.out.println("Calling DAO");
//            String retStr = dao.insertEmployee(e);
//            int ret = Integer.parseInt(retStr.substring(0,1));
//
//            if(ret!=0){
//                out.println("<H2>Employee added<H2/>");
//                out.println("<H2>" + retStr.substring(1) + "<H2/>");
//
//            }else {
//                out.println("<H2>Employee not added<H2/>");
//            }
//
//
//        }

//        if(url.contains("removeemployee")){
//
//            System.out.println("Removing");
//
//            int id = Integer.parseInt(request.getParameter("id"));
//            String retStr = dao.removeEmployee(id);
//            int ret = Integer.parseInt(retStr.substring(0,1));
//            String removedEmployee = retStr.substring(1);
//            if(ret!=0){
//                out.print("<h2>Employee removed<h2/>");
//                out.print("<h2>" + removedEmployee + "<h2/>");
//
//            }else{
//                out.print("<h2>Employee not removed<h2/>");
//            }
//
//
//        }

//        out.println("<a href=\"http://localhost:8081/UsersTableDemo_war_exploded/index.html\">Home</a>");
//        out.println("</body></html>");

    }



    public void destroy() {

    }


}

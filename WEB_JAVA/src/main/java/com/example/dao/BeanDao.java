package com.example.dao;

import com.example.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeanDao {

    ResultSet rs = null;
    String user = "root";
    String url = "jdbc:mysql://localhost:3307";
    String pass = "root123";
    String query = "select * from test.employee";
    Employee e1;
    List<Employee> list = new ArrayList<>(0);

    public List<Employee> getAllTables() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sal = rs.getInt("salary");
                e1 = new Employee(id,name,age, sal);
                list.add(e1);
            }

            System.out.println("Result Set is obtained");

        } catch (SQLException e) {
            System.out.println("error occurred");
            System.out.println(e);
        }

//        if(list.isEmpty()){
//            System.out.println("Empty List");
//        }

        return list;

    }

    public String insertEmployee(Employee empIn){

        int res=0;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement st = con.prepareStatement("insert into test.employee values (?, ?, ?, ?)");
            st.setString(1, String.valueOf(empIn.getId()));
            st.setString(2, empIn.getName());
            st.setString(3, String.valueOf(empIn.getAge()));
            st.setString(4, String.valueOf(empIn.getSalary()));

            res = st.executeUpdate();

            System.out.println("Inserted into dB");

        } catch (SQLException e) {
            System.out.println("Insertion failed");
            System.out.println(e);
        }


        return res + empIn.toString();
    }


    public String removeEmployee(int id){
        int ret=0;

        System.out.println("DAO : " + id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement stq = con.prepareStatement("select * from test.employee where id=?");
            stq.setString(1, String.valueOf(id));

            ResultSet rs = stq.executeQuery();
            rs.next();
            int iid = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            int sal = rs.getInt("salary");

            e1 = new Employee(iid, name, age, sal);
            System.out.println(e1);

            PreparedStatement st = con.prepareStatement("delete from test.employee where id=?");
            st.setString(1, String.valueOf(id));

            System.out.println("Removing from dB");

            ret = st.executeUpdate();


        } catch (SQLException e) {
            ret=0;
            System.out.println("Deletion failed");
            System.out.println(e);
            return ret + "Unable to remove Employee with ID : " + id;
        }

        return ret + e1.toString();
    }


}

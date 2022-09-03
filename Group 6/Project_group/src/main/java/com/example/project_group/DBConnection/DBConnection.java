package com.example.project_group.DBConnection;

import java.sql.*;

public class DBConnection {
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String DatabaseName = "course_registration_system";
    private final String DatabaseUser = "root";
    private final String DatabasePassword = "";
    private final String url = "jdbc:mysql://" + DatabaseUser + ":" + DatabasePassword + "@" + "localhost/" + DatabaseName;


    public DBConnection() throws Exception {
        Class.forName(Driver);
        connection = DriverManager.getConnection(url);
    }


    Connection connection = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;

    public int submit(String Position,String username,String email,String password,String iD) throws SQLException {
        String query = "INSERT INTO `registration`(`Position`, `Username`, `Email`, `password`, `User_ID`) values(?,?,?,?,?)";
        prepStatement = connection.prepareStatement(query);
        prepStatement.setString(1, Position);
        prepStatement.setString(2, username);
        prepStatement.setString(3, email);
        prepStatement.setString(4, password);
        prepStatement.setString(5, iD);

        return prepStatement.executeUpdate();
    }


    public int login(String type, String Username,String password) throws SQLException {
        prepStatement = connection.prepareStatement("SELECT `Position`, `Username`, `password` FROM `registration` WHERE Position = ? and Username=? and password=?");

        prepStatement.setString(1,type);
        prepStatement.setString(2,Username);
        prepStatement.setString(3,password);
        resultSet = prepStatement.executeQuery();
        if (resultSet.next()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int SubmitCourse(String CourseName,String ID, String CreditHours) throws SQLException {
     String query="INSERT INTO `course`(`Course_Name`, `Course_id`, `Credit_hour`) value(?, ?, ?)";
        prepStatement = connection.prepareStatement(query);
     prepStatement.setString(1,CourseName);
     prepStatement.setString(2,ID);
     prepStatement.setString(3,CreditHours);

        return prepStatement.executeUpdate();
    }

    public int SubmitInstructor(String firstName, String Lastname,String ID,String email) throws SQLException {
        String query="INSERT INTO `instructor`(`First_name`,`Last_name`,`Instructor_id`,`Email`) values(?,?,?,?)";

        prepStatement = connection.prepareStatement(query);

        prepStatement.setString(1,firstName);
        prepStatement.setString(2,Lastname);
        prepStatement.setString(3,ID);
        prepStatement.setString(4,email);

        return prepStatement.executeUpdate();
    }

    public int SubmitSection(String Section_ID, String Number,String Class,String Day_time) throws SQLException {
        String query="INSERT INTO `section`(`Section_id`,`Number`,`Classroom`,`Date_Time`) values(?,?,?,?)";
        prepStatement = connection.prepareStatement(query);

        prepStatement.setString(1,Section_ID);
        prepStatement.setString(2,Number);
        prepStatement.setString(3,Class);
        prepStatement.setString(4,Day_time);

        return prepStatement.executeUpdate();
    }

    public int SubmitStudent(String firstname, String lastname,String Student_Id,String Email) throws SQLException {
        String query="INSERT INTO `student`( `First_name`,`Last_Name`,`Student_id`,`Email`) values(?,?,?,?)";
        prepStatement = connection.prepareStatement(query);

        prepStatement.setString(1,firstname);
        prepStatement.setString(2,lastname);
        prepStatement.setString(3,Student_Id);
        prepStatement.setString(4,Email);

        return prepStatement.executeUpdate();
    }
}

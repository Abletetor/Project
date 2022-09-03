package com.example.project_group.Controller;

import com.example.project_group.Startapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main_PageController {

    @FXML
    private Button COURSE;

    @FXML
    private Button Instructor;

    @FXML
    private Button Section;

    @FXML
    private Button Student;

    @FXML
    void CourseShow(ActionEvent event) throws IOException {
        Stage stage=(Stage) COURSE.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Course.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void InstructorShow(ActionEvent event) throws IOException {
      Stage stage=(Stage) Instructor.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Instructor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SectionShow(ActionEvent event) throws IOException {
      Stage stage=(Stage) Section.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Instructor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void StudentShow(ActionEvent event) throws IOException {
       Stage stage=(Stage) Student.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Student.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Management System");
        stage.setScene(scene);
        stage.show();
    }

}

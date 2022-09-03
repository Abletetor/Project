package com.example.project_group.Controller;

import com.example.project_group.DBConnection.DBConnection;
import com.example.project_group.Startapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CourseController {

    @FXML
    private TextField Course_id;

    @FXML
    private TextField Course_name;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_submit;

    @FXML
    private Button btn_Exit;

    @FXML
    private TextField credit_hours;

    @FXML
    void Exit(ActionEvent event) {
        Stage stage=(Stage)btn_Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void out(ActionEvent event) throws IOException {
        Stage stage=(Stage) btn_menu.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Main_Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Registration System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submit(ActionEvent event) throws Exception {
        String CourseName=Course_name.getText();
        String ID=Course_id.getText();
        String CreditHours=credit_hours.getText();

        DBConnection course=new DBConnection();

        if(course.SubmitCourse(CourseName,ID,CreditHours)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submit successful");
            alert.setHeaderText(null);
            alert.showAndWait();

            Course_id.clear();
            Course_name.clear();
            credit_hours.clear();
        }
    }

}

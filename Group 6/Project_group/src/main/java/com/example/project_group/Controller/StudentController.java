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

import java.io.IOException;

public class StudentController {

    @FXML
    private TextField Firstname;

    @FXML
    private TextField Lastname;

    @FXML
    private TextField Student_email;

    @FXML
    private TextField Student_id;

    @FXML
    private Button btn_Main;

    @FXML
    private Button btn_Exit;

    @FXML
    private Button btn_sumit;

    @FXML
    void Exit(ActionEvent event) {
        Stage stage=(Stage)btn_Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void out(ActionEvent event) throws IOException {
        Stage stage=(Stage) btn_Main.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Main_Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Registration System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submit(ActionEvent event) throws Exception {
        String firstname=Firstname.getText();
        String lastname=Lastname.getText();
        String Student_Id=Student_id.getText();
        String Email=Student_email.getText();

        DBConnection student=new DBConnection();
        if(student.SubmitStudent( firstname, lastname,Student_Id,Email)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submitted successfully");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

}

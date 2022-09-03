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

public class InstructorController {

    @FXML
    private TextField Email;

    @FXML
    private TextField Inst_id;

    @FXML
    private Button btn_Exit;
    @FXML
    private Button btn_Main;

    @FXML
    private Button btn_Submit;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    void Exit(ActionEvent event) {
        Stage stage=(Stage)btn_Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void out(ActionEvent event) throws IOException {
        Stage stage=(Stage) btn_Main.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Course Registration System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submit(ActionEvent event) throws Exception {
        String firstName=firstname.getText();
        String Lastname= lastname.getText();
        String ID=Inst_id.getText();
        String email=Email.getText();

        DBConnection instructor=new DBConnection();
        if(instructor.SubmitInstructor(firstName, Lastname,ID,email)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submitted successfully");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

}

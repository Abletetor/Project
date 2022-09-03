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

public class SectionController {

    @FXML
    private TextField Txt_Day_time;

    @FXML
    private TextField Txt_Number;

    @FXML
    private TextField Txt_classroom;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_menu;

    @FXML
    private TextField Txt_section_id;

    @FXML
    void ExitShow(ActionEvent event) {
        Stage stage=(Stage)btn_exit.getScene().getWindow();
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
        String Section_ID=Txt_section_id.getText();
        String Number=Txt_Number.getText();
        String Class=Txt_classroom.getText();
        String Day_time=Txt_Day_time.getText();

        DBConnection submitSection =new DBConnection();
        if(submitSection.SubmitSection(Section_ID,Number,Class,Day_time)==1){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Submitted successfully");
                alert.setHeaderText(null);
                alert.showAndWait();

            }
    }

}

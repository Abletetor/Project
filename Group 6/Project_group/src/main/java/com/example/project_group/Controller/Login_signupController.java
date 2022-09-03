package com.example.project_group.Controller;

import com.example.project_group.DBConnection.DBConnection;
import com.example.project_group.Startapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login_signupController implements Initializable {

    @FXML
    private TextField ID;

    @FXML
    private PasswordField Txt_password_login;

    @FXML
    private ComboBox Type;

    @FXML
    private ComboBox Type_up;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_exit_up;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_submit;

    @FXML
    private AnchorPane pane_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_email_up;

    @FXML
    private PasswordField txt_password;


    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_username_up;

    @FXML
    void CancelShow(ActionEvent event) {
        Stage stage= (Stage) btn_cancel.getScene().getWindow();
        stage.close();

    }

    @FXML
    void ExitShow(ActionEvent event) {
        Stage stage= (Stage) btn_exit_up.getScene().getWindow();
        stage.close();

    }

    @FXML
    void LoginpaneShow(ActionEvent event) {
        pane_login.setVisible(true);
        pane_signup.setVisible(false);

    }

    @FXML
    void SignuppaneShow(ActionEvent event) {
        pane_signup.setVisible(true);
        pane_login.setVisible(false);

    }

    @FXML
    void SubmitShow(ActionEvent event) throws Exception {
        String Position=Type_up.getValue().toString();
        String username=txt_username_up.getText();
        String email=txt_email_up.getText();
        String password=txt_password.getText();
        String iD=ID.getText();

        DBConnection submit= new DBConnection();
        if (submit.submit(Position,username,email, password, iD)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("SignUp successful");
            alert.setHeaderText(null);
            alert.showAndWait();

            Type_up.cancelEdit();
            txt_username_up.clear();
            txt_email_up.clear();
            txt_password.clear();
            ID.clear();

            pane_login.setVisible(true);
            pane_signup.setVisible(false);

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("SignUp Error!!!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

    @FXML
    void btn_loginShow(ActionEvent event) throws Exception {
        String type=Type.getValue().toString();
        String Username=txt_username.getText();
        String password=Txt_password_login.getText();

        DBConnection log_in=new DBConnection();
        if (log_in.login(type,Username,password)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Login successful");
            alert.setHeaderText(null);
            alert.showAndWait();

            Type.cancelEdit();
            txt_username.clear();
            txt_password.clear();

            Stage stage=(Stage) btn_login.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Main_Page.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Course Registration System");
            stage.setScene(scene);
            stage.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Login Error!!!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Type.getItems().addAll("Admin","Client","National Service Personnal","Cashier" );
        Type_up.getItems().addAll("Admin","Client","National Service Personnal","Cashier" );

    }
}


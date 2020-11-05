package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.ConnectionUtil;


import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class ControllerSignIn {

    public Button buttonWin2;
    Connection conn;
    public ControllerSignIn() {
        conn = ConnectionUtil.connDB();
    }
    String email = "";
    String login = "";
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button buttonToWin1;


    @FXML
    private void SignIn(ActionEvent event) throws SQLException {
        String sqlDB = "SELECT login,email FROM users WHERE login = ? and email = ?";
        PreparedStatement statement2 = conn.prepareStatement(sqlDB);
        statement2.setString(1,txtLogin.getText());
        statement2.setString(2,txtemail.getText());
        ResultSet result2 = statement2.executeQuery();
        while (result2.next()){
            email = result2.getString("email");
            login = result2.getString("login");
        }
        if (txtLogin.getText().equals(login)  && txtemail.getText().equals(email)){
            lblStatus.setText("Данный пользователь существует");
        }else {
            String sql = "INSERT INTO users (firstName, lastName, email, login, password) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, txtFirstName.getText());
            statement.setString(2, txtLastname.getText());
            statement.setString(3, txtemail.getText());
            statement.setString(4, txtLogin.getText());
            statement.setString(5, txtpassword.getText());
            int result = statement.executeUpdate();
            if (result == 1) {
                lblStatus.setText("ok");
            } else {
                lblStatus.setText("no");
            }
        }
    }

    @FXML
    void initialize () {
        buttonToWin1.setOnAction(event -> {
            buttonToWin1.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/Controllers/SignUp.fxml"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Войти");
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
    @FXML
    public void openRegistr(KeyEvent event)throws IOException{
        KeyCode keyCode = event.getCode();
        if (keyCode == KeyCode.SPACE){
            buttonToWin1.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("/Controllers/SignUp.fxml"));
            primaryStage.setTitle("DB");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
}

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

import java.io.IOException;
import java.sql.*;

public class ControllerSignUp {
    Connection conn;
    public ControllerSignUp(){
        conn = ConnectionUtil.connDB();
    }
    @FXML
    private Label lblInfo;
    @FXML
    private Button buttonToWin2;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button buttonToWin3;
    @FXML
    public void signUp(ActionEvent event) throws SQLException {
        String login = "";
        String password = "";
        String sql = "SELECT login, password FROM users WHERE login = ? and password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, txtLogin.getText());
        statement.setString(2, txtpassword.getText());
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            login = result.getString("login");
            password = result.getString("password");
        }
        if (txtLogin.getText().isEmpty() || txtpassword.getText().isEmpty()) {
            lblInfo.setText("Данные не введены");
        } else {

            if (txtLogin.getText().equals(login) && txtpassword.getText().equals(password)) {
                lblInfo.setText("Вы вошли");
            }
            buttonToWin3.setOnAction(event1 -> {
                buttonToWin3.getScene().getWindow().hide();
                try {
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Show.fxml"));
                    primaryStage.setTitle("DataBase");
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        }


        @FXML
        void initialize (){
            buttonToWin2.setOnAction(event -> {
                buttonToWin2.getScene().getWindow().hide();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/Controllers/SignIn.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Окно регистрации");
                assert root != null;
                stage.setScene(new Scene(root));
                stage.show();
            });
        }
        @FXML
        public void openReg(KeyEvent event)throws IOException{
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.ENTER){
                buttonToWin3.getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("/Controllers/Show.fxml"));
                primaryStage.setTitle("DB");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
        }
}




package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import sample.*;

import javax.swing.text.TabableView;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerShow implements Initializable{
    Connection conn;
    public ControllerShow() {
        conn = ConnectionUtil.connDB();
    }
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpassword;
    @FXML
    private Label lblInfo;
    @FXML
    private TableView<ModelTablesCourses> tableCourses;
    @FXML
    private TableColumn<ModelTablesCourses, String> tableCoursesId;
    @FXML
    private TableColumn<ModelTablesCourses, String> tableCoursesTitle;
    @FXML
    private TableColumn<ModelTablesCourses, String> tableCoursesLenght;
    @FXML
    private TableColumn<ModelTablesCourses, String> tableCoursesDescription;
    @FXML
    private TableView<ModelTableLessons> tableLessons;
    @FXML
    private TableColumn<ModelTableLessons, String> tableLessonsId;
    @FXML
    private TableColumn<ModelTableLessons, String> tableLessonsTeachers;
    @FXML
    private TableColumn<ModelTableLessons, String> tableLessonsCourse;
    @FXML
    private TableColumn<ModelTableLessons, String> tableLessonsRoom;
    @FXML
    private  TableColumn<ModelTableLessons, String> tableLessonsData;
    @FXML
    private  TableColumn<ModelTableTeachers, String> tableteachersId;
    @FXML
    private  TableColumn<ModelTableTeachers, String> tableteachersName;
    @FXML
    private  TableColumn<ModelTableTeachers, String> tableteachersAddress;
    @FXML
    private TableColumn<ModelTableTeachers, String> tableteachersPhone;
    @FXML
    private  TableView<ModelTableTeachers> tableteachers;
    @FXML
    private TableView<ModelTableUsers> tableusers;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersId;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersFirstName;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersLastname;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersEmail;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersLogin;
    @FXML
    private TableColumn<ModelTableUsers, String> tableusersPassword;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sqlTableCourses = "SELECT * FROM courses";
        ObservableList<ModelTablesCourses> listTableCourses = FXCollections.observableArrayList();
        ObservableList<ModelTableLessons> listTableLessons = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = conn.prepareStatement(sqlTableCourses);
            ResultSet resultSetCourses = statement.executeQuery();
            while (resultSetCourses.next()){
                listTableCourses.add(new ModelTablesCourses(resultSetCourses.getString(1),
                        resultSetCourses.getString(2),
                        resultSetCourses.getString(3),
                        resultSetCourses.getString(4)));
            }
            tableCoursesId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tableCoursesTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            tableCoursesLenght.setCellValueFactory(new PropertyValueFactory<>("lenght"));
            tableCoursesDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tableCourses.setItems(listTableCourses);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        String sqlTableLessons = "SELECT * FROM lessons";
        try {
            PreparedStatement statement = conn.prepareStatement(sqlTableLessons);
            ResultSet resultSetLessons = statement.executeQuery();
            while (resultSetLessons.next()){
                listTableLessons.add(new ModelTableLessons(resultSetLessons.getString(1),
                        resultSetLessons.getString(2),
                        resultSetLessons.getString(3),
                        resultSetLessons.getString(4),
                        resultSetLessons.getString(5)));
            }
            tableLessonsId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tableLessonsTeachers.setCellValueFactory(new PropertyValueFactory<>("teachers"));
            tableLessonsCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
            tableLessonsRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
            tableLessonsData.setCellValueFactory(new PropertyValueFactory<>("data"));
            tableLessons.setItems(listTableLessons);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlTableTeachers = "SELECT * FROM teachers";
        ObservableList<ModelTableTeachers> listTableTeachers = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = conn.prepareStatement(sqlTableTeachers);
            ResultSet resultSetTeachers = statement.executeQuery();
            while (resultSetTeachers.next()){
                listTableTeachers.add(new ModelTableTeachers(resultSetTeachers.getString(1),
                        resultSetTeachers.getString(2),
                        resultSetTeachers.getString(3),
                        resultSetTeachers.getString(4)));
            }
            tableteachersId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tableteachersName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tableteachersAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            tableteachersPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            tableteachers.setItems(listTableTeachers);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sqlTableUsers = "SELECT * FROM users";
        ObservableList<ModelTableUsers> listTableUsers = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = conn.prepareStatement(sqlTableUsers);
            ResultSet resultSetUsers = statement.executeQuery();
            while (resultSetUsers.next()){
                listTableUsers.add(new ModelTableUsers(resultSetUsers.getString(1),
                        resultSetUsers.getString(2),
                        resultSetUsers.getString(3),
                        resultSetUsers.getString(4),
                        resultSetUsers.getString(5),
                        resultSetUsers.getString(6)));
            }
            tableusersId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tableusersFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tableusersLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tableusersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tableusersLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            tableusersPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            tableusers.setItems(listTableUsers);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    public void pressAdd(ActionEvent event) throws SQLException {

        String sql = "INSERT INTO users (firstNme, lastName, email, login, password) VALUES (?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, txtName.getText());
        statement.setString(2,txtFname.getText());
        statement.setString(3,txtlogin.getText());
        statement.setString(4, txtemail.getText());
        statement.setString(5,txtpassword.getText());
        if(statement.executeUpdate() == 1) {
            lblInfo.setText("Добавлено");
        }

    }
    @FXML
    public void pressUpdate(ActionEvent event) throws SQLException{
        int id = Integer.parseInt(txtid.getText());
        String firstNme = txtName.getText();
        String lastName = txtFname.getText();
        String login = (txtlogin.getText());
        String email = txtemail.getText();
        String password = txtpassword.getText();
        String sql = "UPDATE users SET firstNme = ?, lastName = ?,  email = ?, login = ?, password = ? WHERE id_user = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,firstNme);
        statement.setString(2,lastName);
        statement.setString(3,login);
        statement.setString(4,email);
        statement.setString(5,password);
        statement.setInt(6,id);
        int res = statement.executeUpdate();
        if (res == 1){
            lblInfo.setTextFill(Color.GREEN);
            lblInfo.setText("Update table");
        }

    }
    @FXML
    public void  pressDelete(ActionEvent event) throws SQLException{
        int id = Integer.parseInt(txtid.getText());
        String sqlDelete = "DELETE FROM users WHERE id_user =?";
        PreparedStatement statement = conn.prepareStatement(sqlDelete);
        statement.setInt(1, id);
        int res = statement.executeUpdate();
        if (res == 1) {
            lblInfo.setTextFill(Color.GREEN);
            lblInfo.setText("Данные удалены");
        }
    }

}

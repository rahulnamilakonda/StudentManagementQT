package gui.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class StudentController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button back;

    public void getRegister(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register/studentdetails.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public void getRegisterCourse(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("regsitercourse/regcourse.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public void getcertificate(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("certificate/certificate.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../mainmenu/mainmenu.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        //Text text=new Text("Welcome By NK");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
}

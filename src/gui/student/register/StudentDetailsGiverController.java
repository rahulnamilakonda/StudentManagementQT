package gui.student.register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDetailsGiverController {
    @FXML
    private TextField name;
    @FXML
    private TextField contact;
    @FXML
    private TextField address;
    @FXML
    private TextField age;
    @FXML
    private Button submit;
    @FXML
    private Button back;

    private Stage stage;
    private Parent root;
    private String studentname;
    private long studentcontact;
    private String studentaddress;
    private int studentage;

    public void submitDetails(ActionEvent actionEvent)
    {
        studentname=name.getText();
        studentcontact=Long.parseLong(contact.getText());
        studentaddress=address.getText();
        studentage=Integer.parseInt(age.getText());
        //Database code to enter
        System.out.println(""+studentname);
    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../student.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        //Text text=new Text("Welcome By NK");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
}

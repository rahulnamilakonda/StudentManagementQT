package gui.student.register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Database.StudentRegistration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentDetailsGiverController implements Initializable {
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
    @FXML
    private Label labelmsg;

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
        StudentRegistration sr = new StudentRegistration();
        int id =  sr.createStudent(studentname,studentcontact,studentaddress,studentage);
        System.out.println("data inserted");
        System.out.println(""+studentname);
        labelmsg.setStyle("-fx-text-fill: green;");
        labelmsg.setText("Submitted Successfully your id is : "+id);
        labelmsg.setVisible(true);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelmsg.setVisible(false);
    }
}

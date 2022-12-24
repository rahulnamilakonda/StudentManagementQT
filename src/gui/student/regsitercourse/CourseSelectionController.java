package gui.student.regsitercourse;

import Database.RegisterCourse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseSelectionController implements Initializable {
    String[] courses = {"JAVA", "PYTHON", "HTML", "JAVA FULL STACK", "PYTHON FULL STACK"};
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button submit;
    @FXML
    private TextField sid;
    @FXML
    private Button back;
    @FXML
    private Label labelmsg;

    private Stage stage;
    private Parent root;
    private Scene scene;
    private String value;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(courses);
        choiceBox.setOnAction(this::choiceboxOption);
        labelmsg.setVisible(false);
    }

    public void choiceboxOption(ActionEvent actionEvent)
    {
        value = choiceBox.getValue();
        //Database code
        System.out.println("" + value);
    }
    public void submitData(ActionEvent actionEvent) {

        int studentsid = Integer.parseInt(sid.getText());
        //Database code
        RegisterCourse rc = new RegisterCourse();
        rc.enrollCourse(studentsid,value);
        System.out.println(""+studentsid);
        System.out.println(""+studentsid);
        labelmsg.setStyle("-fx-text-fill: green");
        labelmsg.setText("Submitted Succesfully");
        labelmsg.setVisible(true);

    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/student/student.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        //Text text=new Text("Welcome By NK");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
}

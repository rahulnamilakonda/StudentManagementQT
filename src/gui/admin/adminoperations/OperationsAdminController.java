package gui.admin.adminoperations;

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

public class OperationsAdminController implements Initializable {
@FXML
    private ChoiceBox<String> choiceBox;
@FXML
    private TextField course;
@FXML
    private Label label;
@FXML
    private Button back;

    private Stage stage;
    private Parent root;
    private Scene scene;
    private String []operations={"Average Duration","Students Collected certifactes",
    "students 2 installments paid","students 1 installment paid"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    choiceBox.getItems().addAll(operations);
    label.setVisible(false);
    choiceBox.setOnAction(this::selectOperation);
    }
    public void selectOperation(ActionEvent actionEvent)
    {
    String operation=choiceBox.getValue();
    System.out.println(""+operation);
    // Database Code
    label.setText("Number");
    label.setVisible(true);

    }
    public void getStudents(ActionEvent actionEvent)
    {
        String coursename= course.getText();
        System.out.println(""+coursename);
        //Database code
        label.setText("success");
        label.setVisible(true);
    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gui/admin/admin.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
}

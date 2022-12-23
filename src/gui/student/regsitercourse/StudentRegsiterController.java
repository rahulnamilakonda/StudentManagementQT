package gui.student.regsitercourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class StudentRegsiterController {
    @FXML
    private Button submitbutton;
    @FXML
    private AnchorPane anchorPane;
    Stage stage;
    void submit(ActionEvent actionEvent)
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Submit");
        alert.setHeaderText("You are about to Submit");
        alert.setContentText("Do you want to Submit ");
        stage =(Stage)anchorPane.getScene().getWindow();
        if(alert.showAndWait().get()== ButtonType.OK)
        {
            System.out.println("Details are sending");
            stage.close();
        }
    }
}

package gui.student.certificate;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Certificate implements Initializable {
    @FXML
    private final Image image = new Image(getClass().getResourceAsStream("/images/cert.jpg"));
    @FXML
    private ImageView imageView;
    @FXML
    private Label label;
    @FXML
    private TextField sid;
    @FXML
    private TextField cid;
    @FXML
    private Button back;

    private int studentsid;
    private int studentcid;
    private Parent root;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView.setImage(image);
        label.setVisible(false);
        imageView.setVisible(true);
    }

    public void downloadCertificate(ActionEvent actionEvent) {
        studentsid = Integer.parseInt(sid.getText());
        studentcid = Integer.parseInt(cid.getText());
        //Database Code
        if (studentsid >= 0) {
            System.out.println("cid: "+studentcid+"sid: "+studentsid);
            // Database code to check whether a student can download or not;
            label.setStyle("-fx-text-fill: green");
            label.setText("Your certificate download");
            label.setVisible(true);

        } else {
            label.setText("Please complete the course");
            label.setStyle("-fx-text-fill: red");
        }

    }

    public void payFirstInstallment(ActionEvent actionEvent) {
        studentsid = Integer.parseInt(sid.getText());
        studentcid = Integer.parseInt(cid.getText());
        System.out.println(""+studentsid);
        //Database code
        label.setText("First installment paid");
        label.setStyle("-fx-text-fill: green");
        label.setVisible(true);
    }

    public void paySecondInstallment(ActionEvent actionEvent) {
        //Database code
        System.out.println(""+studentsid);
        studentsid = Integer.parseInt(sid.getText());
        studentcid = Integer.parseInt(cid.getText());
        label.setText("Second installment paid");
        label.setStyle("-fx-text-fill: green");
        label.setVisible(true);
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

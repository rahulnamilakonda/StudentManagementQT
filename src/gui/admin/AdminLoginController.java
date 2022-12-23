package gui.admin;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label label;
    @FXML
    private Button back;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private String adminusername;
    private String adminpassword;
    public void submit(ActionEvent actionEvent) throws IOException {
        label.setVisible(true);
    adminusername=username.getText();
    adminpassword=password.getText();
    if(adminusername.equals("admin") && adminpassword.equals("admin"))
    {
        label.setVisible(true);
        label.setText("Success");

        //Scene Swticher
        Parent root = FXMLLoader.load(getClass().getResource("adminoperations/operationsadmin.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        //Text text=new Text("Welcome By NK");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
    }
    else
    {
        label.setVisible(true);
        label.setText("Failed");

    }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setVisible(false);
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

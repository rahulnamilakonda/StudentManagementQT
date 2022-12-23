package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainController extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void close(Stage stage)
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setHeaderText("You're about to Close!");
        alert.setContentText("Do you want to exit?");

        if(alert.showAndWait().get()== ButtonType.OK)
        {
            System.out.println("closing");
            stage.close();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
//        Group root =new Group();
//        Scene scene = new Scene(root);
//        Text text=new Text();
//        Line line =new Line();
//        line.setStartX(195);
//        line.setStartY(53);
//        line.setEndX(320);
//        line.setEndY(53);
//
//
//        stage.setScene(scene);
//        text.setText("Welcome");
//        text.setX(195);
//        text.setY(50);
//        text.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));
//        stage.setTitle("QT Management");
//        Image icon =new Image("images/icon.png");
//        stage.getIcons().add(icon);
//        stage.setWidth(550);
//        root.getChildren().add(text);
//        root.getChildren().add(line);
//        stage.setHeight(550);
//        stage.setResizable(false);
//        stage.show();
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu/mainmenu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("QT Management");
        //Text text=new Text("Welcome By NK");
        Image icon = new Image("images/icon.png");
        stage.getIcons().add(icon);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            close(stage);
        });

    }
}

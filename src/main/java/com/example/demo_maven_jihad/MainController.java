package com.example.demo_maven_jihad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class MainController {

    @FXML
    private Button btn_about;

    @FXML
    private Button btn_decryption;

    @FXML
    private Button btn_encryption;

    //


    @FXML
    void setOnMouseEntered(MouseEvent event) {
        btn_encryption.setCursor(Cursor.HAND);
        btn_decryption.setCursor(Cursor.HAND);
        btn_about.setCursor(Cursor.HAND);
    }

    @FXML
    void setOnMouseExited(MouseEvent event) {
        btn_encryption.setCursor(Cursor.DEFAULT);
        btn_decryption.setCursor(Cursor.DEFAULT);
        btn_about.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void switchToAbout(ActionEvent event) throws IOException {
        // Load the FXML file for the custom dialog
        FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
        AnchorPane customDialogPane;
        try {
            customDialogPane = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        //Create a new stage for the custom dialog
        Stage customDialogStage = new Stage();
        customDialogStage.setTitle("About");
        customDialogStage.initStyle(StageStyle.UNDECORATED);
        customDialogStage.setScene(new Scene(customDialogPane));

        // Get the controller instance and set the customDialogStage reference
        AboutController controller = loader.getController();
        controller.setDialogStage(customDialogStage);

        customDialogStage.show();
    }

    @FXML
    void switchToDecryption(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("decryption.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToEncryption(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("encryption.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}



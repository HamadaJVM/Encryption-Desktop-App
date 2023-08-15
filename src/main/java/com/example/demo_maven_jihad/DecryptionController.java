package com.example.demo_maven_jihad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class DecryptionController {
// FXML vars
    @FXML
    private ImageView image_back;

    @FXML
    private ImageView image_copy_department;

    @FXML
    private ImageView image_copy_name;

    @FXML
    private ImageView image_copy_title;
    @FXML
    private ImageView image_clear_all;

    @FXML
    private Text lable_the_technical_section;

    @FXML
    private TextField text_department;

    @FXML
    private TextField text_entery;

    @FXML
    private TextField text_name;

    @FXML
    private TextField text_title;

    public String CodeName;
    public Character CodeTitle, CodeDepartment;
    public String name,title,department;
    @FXML
    void enter(ActionEvent event) {
        try {
            splitCode();
            decryption();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        fillValuesInTexts();

    }
    void emptyAllTexts(){
        text_name.setText("");
        text_title.setText("");
        text_department.setText("");
        text_entery.setText("");
    }
    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void clearAll(MouseEvent event) {
            emptyAllTexts();
    }


    @FXML
    void copyName(MouseEvent event) {
        copyToClipboard(text_name.getText());
        image_copy_name.setCursor(Cursor.NONE);
    }

    @FXML
    void copyTitle(MouseEvent event) {
        copyToClipboard(text_title.getText());
        image_copy_title.setCursor(Cursor.NONE);
    }

    @FXML
    void copy_department(MouseEvent event) {
        copyToClipboard(text_department.getText());
        image_copy_department.setCursor(Cursor.NONE);
    }

    @FXML
    void setOnMouseEntered(MouseEvent event) {
        image_copy_name.setCursor(Cursor.HAND);
        image_copy_title.setCursor(Cursor.HAND);
        image_copy_department.setCursor(Cursor.HAND);
        image_back.setCursor(Cursor.HAND);
        image_clear_all.setCursor(Cursor.HAND);

    }
    @FXML
    void changeItsColor(MouseEvent event){
        lable_the_technical_section.setVisible(true);
    }
   @FXML
    void changeItsColorBack(MouseEvent event){
        lable_the_technical_section.setVisible(false);
    }
    void splitCode(){
        int length = text_entery.getLength();
        CodeTitle =  text_entery.getText(0,1).charAt(0);
        CodeDepartment = text_entery.getText(1,2).charAt(0);
        CodeName = text_entery.getText(2,length);
    }
    void decryption(){
        name = InfoConverter.nameDecryption(CodeName);
        title = InfoConverter.titleDecryption(CodeTitle);
        department = InfoConverter.departmentDecryption(CodeDepartment);
    }
    void fillValuesInTexts(){
        text_name.setText(name);
        text_title.setText(title);
        text_department.setText(department);
    }
    void copyToClipboard(String text) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }

}

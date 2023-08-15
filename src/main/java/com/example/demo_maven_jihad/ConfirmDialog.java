package com.example.demo_maven_jihad;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class ConfirmDialog {
    @FXML
    private AnchorPane copy_interface;
    @FXML
    private AnchorPane main_interface;

    private Stage dialogStage;
    @FXML
    private ImageView image_back;

    @FXML
    private ImageView image_confirm;

    @FXML
    private Text text_department;

    @FXML
    private Text text_name;

    @FXML
    private Text text_title;

    @FXML
    private ImageView image_copy;
    @FXML
    private TextField text_final;
    private String name ,title,department;


    @FXML
    void setOnMouseEntered(MouseEvent event) {

        image_back.setCursor(Cursor.HAND);
        image_confirm.setCursor(Cursor.HAND);
        image_copy.setCursor(Cursor.HAND);

    }
    @FXML
    void back(MouseEvent event) {

        animateFadeOutAndClose();

    }
    @FXML
    void confirm(MouseEvent event) {
        // مهم جدا لاحظ طريقة و تسلسل دمج النص
        String encryptionFinalText = InfoConverter.titleEncryption(title) +
                InfoConverter.departmentEncryption(department) +
                InfoConverter.nameEncryption(name);
        //
        switchToCopyInterface( encryptionFinalText );
    }
    @FXML
    void copy(MouseEvent event) {
        copyToClipboard(text_final.getText());
        animateFadeOutAndClose();
    }


    void switchToCopyInterface(String text){
          main_interface.setVisible(false);
          copy_interface.setVisible(true);
          text_final.setText(text);
    }
    // Copy text to clipboard
    private void copyToClipboard(String text) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
    // Method to set the Stage reference
    public void setDialogStage(Stage stage) {
        this.dialogStage = stage;
    }
    private void animateFadeOutAndClose() {
        // Create a Timeline for the fade-out animation
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(dialogStage.getScene().getRoot().opacityProperty(), 0);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
        timeline.getKeyFrames().add(keyFrame);

        // Set an event handler to close the dialog when the animation finishes
        timeline.setOnFinished(event -> dialogStage.close());

        // Play the animation
        timeline.play();

    }
    public void getDataAndDisplay(String name, String title, String department){
        if (isNotNull(name,title,department)){
        this.name = removeExtraSpaces(name);
        this.title = title;
        this.department = department;
            displayData();
        }else{
            this.name = "Error";
            this.title = "Error";
            this.department = "Error";
            image_confirm.setVisible(false);
            displayData();
        }

    }
    public void displayData(){

            text_name.setText(name);
            text_title.setText(title);
            //هذا الشرط بس علمود يحذف شعبة الكلية الصناعيه و يخلي بس الفروع مالته
            // لأن ماكو داعي تنكتب
            if (department.contains("/")) {
                String[] arr = department.split("/");
                text_department.setText(arr[1]);
            } else
                text_department.setText(department);

    }

    public static String removeExtraSpaces(String input) {
        // Replace consecutive spaces with a single space
        return input.replaceAll("\\s+", " ").trim();
    }
    public boolean isNotNull(String name, String title, String department){
        return ( (name != null && !name.isEmpty())&&(title != null && !title.isEmpty())
                &&(department != null && !department.isEmpty()));
    }
}

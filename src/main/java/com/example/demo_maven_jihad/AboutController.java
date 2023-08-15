
package com.example.demo_maven_jihad;

        import javafx.animation.*;
        import javafx.fxml.FXML;
        import javafx.scene.Cursor;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.awt.*;
        import java.io.IOException;
        import java.net.URI;
        import java.net.URISyntaxException;

public class AboutController {

    @FXML
    private ImageView img_clikc_linkedin;

    @FXML
    private ImageView img_clikc_telegram;
    @FXML
    private ImageView img_clikc_back;
    @FXML
    private Stage dialogStage;

    @FXML
    void setOnMouseEntered(MouseEvent event) {

        img_clikc_back.setCursor(Cursor.HAND);
        img_clikc_telegram.setCursor(Cursor.HAND);
        img_clikc_linkedin.setCursor(Cursor.HAND);

    }
    @FXML
    void back_click(MouseEvent event) {
        animateFadeOutAndClose();

    }

    @FXML
    void linkedin_click(MouseEvent event) {
        openLinkedInProfile();
    }

    @FXML
    void telegram_click(MouseEvent event) {
        openTelegramProfile();
    }


    public static void openTelegramProfile() {
        try {
            String telegramUsername = "hmada_JVM";

            URI uri = new URI("https://t.me/" + telegramUsername);

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(uri);
            } else {
                // If the desktop is not supported, you can handle the fallback behavior here
                System.out.println("Unable to open browser. Please visit: " + uri);
            }
        } catch (IOException | URISyntaxException e) {
            // Handle any exceptions that may occur while opening the URL
            e.printStackTrace();
        }
    }
    public static void openLinkedInProfile() {
        try {
            String linkedinUsernameOrProfileURL = "muhammad-bj-773m";

            URI uri = new URI("https://www.linkedin.com/in/" + linkedinUsernameOrProfileURL);

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(uri);
            } else {
                // If the desktop is not supported, you can handle the fallback behavior here
                System.out.println("Unable to open browser. Please visit: " + uri);
            }
        } catch (IOException | URISyntaxException e) {
            // Handle any exceptions that may occur while opening the URL
            e.printStackTrace();
        }
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
        // Create a FadeTransition for the fade-out animation

    }

}

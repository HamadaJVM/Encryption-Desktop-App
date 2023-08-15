module com.example.demo_maven_jihad {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires java.desktop;
    requires com.google.common;


    opens com.example.demo_maven_jihad to javafx.fxml;
    exports com.example.demo_maven_jihad;
}
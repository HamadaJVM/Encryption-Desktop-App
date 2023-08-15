package com.example.demo_maven_jihad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EncryptionController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox_employee_title;
    @FXML
    private ChoiceBox<String> choiceBox_employee_department;
    @FXML
    private TextField edit_text_name;
    @FXML
    private CheckBox check_box_title;

    @FXML
    private CheckBox check_box_Unit;
    @FXML
    private ImageView image_done;

    @FXML
    public ImageView image_view_back;
    @FXML
    static String name , title, department;

    //chose box data is here:

    String[] titleDataWithoutM = {"صيدلاني", "معالج طبي", "كيمياوي", "بايلوجي", "طبيب اختصاص", "ملاحظ", "مهندس"
                , "تقني بصريات", "تقني احيائي", "ت.طبي", "ت.تحليلات"};
    String[] titleDataWithM = {"م.صيدلي", "م.بايلوجي", "م.كيماوي", "م.مختبر", "م.محلل مختبر", "م.باحث صحة بيئية"
                , "م.طبي", "م.ماهر", "م.جامعي", "م.فني", "م.اغذيه"};
    String[] departmentDataWithOutUnits = {"أدارة القسم الفني", "شعبة الاحصاء", "شعبة الصيدلة", "شعبة المختبر"
                , "شعبة الكلية الصناعيه/صيديلة الديلزة", "شعبة الكلية الصناعيه/الكادر التمريضي"
                , "شعبة الكلية الصناعيه/مختبر الديلزة"};
    String[] departmentDataWithUnits = {"وحدة مكافحة العدوى", "وحدة الصحة العامة", "وحدة الأعاشة", "وحدة فحص المياه"
                , "وحدة الأجهزة الطبية", "وحدة السيطرة على المضادات ", "وحدة الأجازات و التقارير", "وحدة فحص الجثث"
                , "وحدة العوز المناعي", "وحدة قضايا الشرطة"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox_employee_title.getItems().addAll(titleDataWithoutM);
        choiceBox_employee_title.setOnAction(this::getItemSelected1);

        choiceBox_employee_department.getItems().addAll(departmentDataWithOutUnits);
        choiceBox_employee_department.setOnAction(this::getItemSelected2);


    }
    @FXML
    void setOnMouseEntered(MouseEvent event) {

        edit_text_name.setCursor(Cursor.TEXT);
        check_box_title.setCursor(Cursor.HAND);
        check_box_Unit.setCursor(Cursor.HAND);
        image_view_back.setCursor(Cursor.HAND);
        image_done.setCursor(Cursor.HAND);

    }

    @FXML
    void UnitCheckBoxChange(ActionEvent event) {
        //
        enableButtonsBack();
        //
        if (!check_box_Unit.isSelected()){
            choiceBox_employee_department.getItems().clear();
            choiceBox_employee_department.getItems().addAll(departmentDataWithOutUnits);
        }else{
            choiceBox_employee_department.getItems().clear();
            choiceBox_employee_department.getItems().addAll(departmentDataWithUnits);
        }
    }
    @FXML
    void departmentCheckBoxChange(ActionEvent event) {
        //
        enableButtonsBack();
        //
        if (!check_box_title.isSelected()) {
            choiceBox_employee_title.getItems().clear();
            choiceBox_employee_title.getItems().addAll(titleDataWithoutM);
        }else{
            choiceBox_employee_title.getItems().clear();
            choiceBox_employee_title.getItems().addAll(titleDataWithM);

        }

    }
    @FXML
    void clickBack(MouseEvent event) throws IOException {
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
    void clickDone(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmDialog.fxml"));
        AnchorPane customDialogPane;
        try {

            customDialogPane = loader.load();
        } catch (Exception e) {
            e.getMessage();
            return;
        }

        // Create a new stage for the custom dialog
        Stage customDialogStage = new Stage();
        customDialogStage.setTitle("confirmDialog");
        customDialogStage.initStyle(StageStyle.UNDECORATED);
        customDialogStage.setScene(new Scene(customDialogPane));

        // Get the controller instance and set the customDialogStage reference
        ConfirmDialog controller = loader.getController();
        // Set the dialog stage for the ConfirmDialogController
        controller.setDialogStage(customDialogStage);
        controller.getDataAndDisplay(getName(),getTitle(),getDepartment());

        customDialogStage.show();

          image_done.setVisible(false);
          //image_view_back.setVisible(false);
    }
    @FXML
    void enterName(ActionEvent event) {
        //This method will run when the user press the Enter kye so the focus will
        //transform to the element bellow
        choiceBox_employee_title.requestFocus();
        enableButtonsBack();
    }
    public String getItemSelected1(ActionEvent event){
        //
        enableButtonsBack();
        //
        title = choiceBox_employee_title.getValue();
        return choiceBox_employee_title.getValue();

    }
    public String getItemSelected2(ActionEvent event){
        //
        enableButtonsBack();
        //
        department = choiceBox_employee_department.getValue();
        return choiceBox_employee_department.getValue();

    }

    public boolean isNameNotNull(String name){
        return name.matches("^[\\p{InArabic}\\s]+$");
    }

    public String getName() {
        name = edit_text_name.getText().toString();
        if (isNameNotNull(name)){
            return name;
        }else
            return null;
    }
    public String getTitle(){
        return title;
    }
    public String getDepartment(){
        return department;
    }
    public void enableButtonsBack(){
        image_view_back.setVisible(true);
        image_done.setVisible(true);
    }

}

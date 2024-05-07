module com.macchinina {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.macchinina to javafx.fxml;
    exports com.macchinina;
}
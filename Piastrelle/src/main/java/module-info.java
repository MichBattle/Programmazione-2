module com.piastrelle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.piastrelle to javafx.fxml;
    exports com.piastrelle;
}
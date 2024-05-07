module com.tre {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tre to javafx.fxml;
    exports com.tre;
}
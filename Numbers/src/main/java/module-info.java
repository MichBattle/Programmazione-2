module com.numbers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.numbers to javafx.fxml;
    exports com.numbers;
}
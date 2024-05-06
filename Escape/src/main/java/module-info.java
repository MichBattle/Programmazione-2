module controller.escape {
    requires javafx.controls;
    requires javafx.fxml;


    opens controller.escape to javafx.fxml;
    exports Control;
}
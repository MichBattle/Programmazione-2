module org.example.geraltgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.geraltgui to javafx.fxml;
    exports org.example.geraltgui;
}
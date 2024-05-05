module org.example.streamthis {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.streamthis to javafx.fxml;
    exports Main;
    opens Main to javafx.fxml;
}
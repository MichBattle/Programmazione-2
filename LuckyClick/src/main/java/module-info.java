module org.example.luckyclick {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.luckyclick to javafx.fxml;
    exports org.example.luckyclick;
}
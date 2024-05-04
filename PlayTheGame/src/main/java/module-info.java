module org.example.playthegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.playthegame to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
}
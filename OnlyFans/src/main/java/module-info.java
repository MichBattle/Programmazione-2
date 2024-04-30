module org.example.onlyfans {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.onlyfans to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Main;
    opens Main to javafx.fxml;
    exports Controller.Ventilators;
    opens Controller.Ventilators to javafx.fxml;
}
module org.example.run {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.run to javafx.fxml;
    exports org.example.run;
}
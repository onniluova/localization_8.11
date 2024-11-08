module org.example.localization_8_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.localization_8_11 to javafx.fxml;
    exports org.example.localization_8_11;
}
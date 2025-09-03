module com.example.javabasiccalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javabasiccalculator to javafx.fxml;
    exports com.example.javabasiccalculator;
}
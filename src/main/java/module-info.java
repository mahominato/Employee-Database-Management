module com.example.employeedm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.employeedm to javafx.fxml;
    exports com.example.employeedm;
}
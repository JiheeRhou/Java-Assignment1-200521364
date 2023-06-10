module com.example.javaassignment1200521364 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaassignment1200521364 to javafx.fxml;
    exports com.example.javaassignment1200521364;
}
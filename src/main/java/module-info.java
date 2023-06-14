module com.example.javaassignment1200521364 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaassignment1200521364 to javafx.fxml;
    exports com.example.javaassignment1200521364;
    exports com.example.javaassignment1200521364.Controller;
    opens com.example.javaassignment1200521364.Controller to javafx.fxml;
    exports com.example.javaassignment1200521364.Model;
    opens com.example.javaassignment1200521364.Model to javafx.fxml;
    exports com.example.javaassignment1200521364.Utilities;
    opens com.example.javaassignment1200521364.Utilities to javafx.fxml;
}
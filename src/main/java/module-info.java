module com.example.srsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;


    opens com.example.srsfx to javafx.fxml;
    exports com.example.srsfx;
}
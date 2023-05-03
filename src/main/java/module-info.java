module com.example.srsfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.srsfx to javafx.fxml;
    exports com.example.srsfx;
}
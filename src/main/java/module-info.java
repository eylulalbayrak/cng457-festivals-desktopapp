module com.example.cng457desktopapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cng457desktopapp to javafx.fxml;
    exports com.example.cng457desktopapp;
}
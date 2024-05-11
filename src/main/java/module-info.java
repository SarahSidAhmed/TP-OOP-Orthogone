module com.example.cabinetorthophone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cabinetorthophone to javafx.fxml;
    exports com.example.cabinetorthophone;
    exports com.example.cabinetorthophone.modules;
    opens com.example.cabinetorthophone.modules to javafx.fxml;
}
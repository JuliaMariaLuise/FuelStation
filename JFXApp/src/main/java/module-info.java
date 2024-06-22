module com.fuelstation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.fuelstation to javafx.fxml;
    exports com.fuelstation;
}

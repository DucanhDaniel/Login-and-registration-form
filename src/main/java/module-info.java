module jfx.cmnbtwcontroller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens jfx.cmnbtwcontroller to javafx.fxml;
    exports jfx.cmnbtwcontroller;
}
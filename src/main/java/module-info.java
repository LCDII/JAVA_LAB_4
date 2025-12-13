module visual.lab_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.graphics;
    requires java.compiler;

    opens visual.lab_4 to javafx.fxml;
    exports visual.lab_4;
}
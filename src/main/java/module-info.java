module visual.lab_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires org.slf4j;
    requires jakarta.persistence;

    opens visual.lab_4 to javafx.fxml, org.hibernate.orm.core;
    opens visual.lab_4.CpuLib to org.hibernate.orm.core;
    exports visual.lab_4;
}
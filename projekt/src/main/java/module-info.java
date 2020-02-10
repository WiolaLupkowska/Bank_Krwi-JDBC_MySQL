module edu.ib {
    requires javafx.controls;
    requires java.sql;
    requires java.sql.rowset;
    requires javafx.fxml;
  //  requires kotlin.stdlib;


    opens edu.ib to javafx.fxml;
    exports edu.ib;




}
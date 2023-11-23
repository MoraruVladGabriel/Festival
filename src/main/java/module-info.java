module com.example.festivalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires java.sql;


    //opens com.example.festivalapp to javafx.fxml;
    exports org.example.festivalapp;
    exports org.example.festivalapp.controllers;
    opens org.example.festivalapp.controllers to javafx.fxml;
    opens org.example.festivalapp to javafx.base;
    opens org.example.festivalapp.domain to javafx.base;
}
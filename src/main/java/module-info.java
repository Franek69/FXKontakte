module com.example.fxkontakte {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxkontakte to javafx.fxml;
    exports com.example.fxkontakte;
}
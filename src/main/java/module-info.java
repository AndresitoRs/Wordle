module di.wordle {
    requires javafx.controls;
    requires javafx.fxml;


    opens di.wordle to javafx.fxml;
    exports di.wordle;
}
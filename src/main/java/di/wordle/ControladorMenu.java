package di.wordle;

import javafx.application.HostServices;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorMenu {

    private HostServices hostServices;

    @FXML
    AnchorPane fondo;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void cargarPantalla1() throws IOException {
        cargarPantalla("wordle.fxml");
    }

    @FXML
    public void cargarPantalla2() throws IOException {
        if (hostServices != null) {
            hostServices.showDocument("https://github.com/AndresitoRs/Wordle");
        } else {
            System.out.println("HostServices no está disponible.");
        }
    }



    public void cargarPantalla(String pantalla) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WordleApp.class.getResource(pantalla));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) fondo.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

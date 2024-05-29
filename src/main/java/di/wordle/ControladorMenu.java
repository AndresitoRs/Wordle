package di.wordle;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenu implements Initializable{
    private HostServices hostServices;
    @FXML
    private AnchorPane fondo;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        URL ruta = getClass().getResource("img/fondo.png");
        String estilo = "-fx-background-image:url('"+ruta+"')";
        fondo.setStyle(estilo);
    }

    public void salir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
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

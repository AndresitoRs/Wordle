package di.wordle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class WordleController implements Initializable {

    private final String palabraOculta = "Caleb";

    private int filaActual = 1;
    private Label casillaSeleccionada;
    @FXML
    private GridPane tablero;
    @FXML
    Label i1l1, i1l2, i1l3, i1l4 ,i1l5, i2l1, i2l2, i2l3, i2l4, i2l5, i3l1, i3l2, i3l3, i3l4, i3l5, i4l1, i4l2, i4l3, i4l4, i4l5, i5l1, i5l2, i5l3, i5l4, i5l5;
    @FXML
    public void iniciarPartida() {

        i1l1.setText("");
        i1l2.setText("");
        i1l3.setText("");
        i1l4.setText("");
        i1l5.setText("");
        i1l1.setOnMouseClicked(this::seleccionar);
        i1l2.setOnMouseClicked(this::seleccionar);
        i1l3.setOnMouseClicked(this::seleccionar);
        i1l4.setOnMouseClicked(this::seleccionar);
        i1l5.setOnMouseClicked(this::seleccionar);

        i2l1.setText("");
        i2l2.setText("");
        i2l3.setText("");
        i2l4.setText("");
        i2l5.setText("");
        i2l1.setOnMouseClicked(this::seleccionar);
        i2l2.setOnMouseClicked(this::seleccionar);
        i2l3.setOnMouseClicked(this::seleccionar);
        i2l4.setOnMouseClicked(this::seleccionar);
        i2l5.setOnMouseClicked(this::seleccionar);

        i3l1.setText("");
        i3l2.setText("");
        i3l3.setText("");
        i3l4.setText("");
        i3l5.setText("");
        i3l1.setOnMouseClicked(this::seleccionar);
        i3l2.setOnMouseClicked(this::seleccionar);
        i3l3.setOnMouseClicked(this::seleccionar);
        i3l4.setOnMouseClicked(this::seleccionar);
        i3l5.setOnMouseClicked(this::seleccionar);

        i4l1.setText("");
        i4l2.setText("");
        i4l3.setText("");
        i4l4.setText("");
        i4l5.setText("");
        i4l1.setOnMouseClicked(this::seleccionar);
        i4l2.setOnMouseClicked(this::seleccionar);
        i4l3.setOnMouseClicked(this::seleccionar);
        i4l4.setOnMouseClicked(this::seleccionar);
        i4l5.setOnMouseClicked(this::seleccionar);


        i5l1.setText("");
        i5l2.setText("");
        i5l3.setText("");
        i5l4.setText("");
        i5l5.setText("");
        i5l1.setOnMouseClicked(this::seleccionar);
        i5l2.setOnMouseClicked(this::seleccionar);
        i5l3.setOnMouseClicked(this::seleccionar);
        i5l4.setOnMouseClicked(this::seleccionar);
        i5l5.setOnMouseClicked(this::seleccionar);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        casillaSeleccionada=i1l1;
        casillaSeleccionada.getStyleClass().add("activa");
        iniciarPartida();
    }

    public void desmarcarTodas() {

        i1l1.getStyleClass().remove("activa");
        i1l2.getStyleClass().remove("activa");
        i1l3.getStyleClass().remove("activa");
        i1l4.getStyleClass().remove("activa");
        i1l5.getStyleClass().remove("activa");

        i2l1.getStyleClass().remove("activa");
        i2l2.getStyleClass().remove("activa");
        i2l3.getStyleClass().remove("activa");
        i2l4.getStyleClass().remove("activa");
        i2l5.getStyleClass().remove("activa");

        i3l1.getStyleClass().remove("activa");
        i3l2.getStyleClass().remove("activa");
        i3l3.getStyleClass().remove("activa");
        i3l4.getStyleClass().remove("activa");
        i3l5.getStyleClass().remove("activa");

        i4l1.getStyleClass().remove("activa");
        i4l2.getStyleClass().remove("activa");
        i4l3.getStyleClass().remove("activa");
        i4l4.getStyleClass().remove("activa");
        i4l5.getStyleClass().remove("activa");

        i5l1.getStyleClass().remove("activa");
        i5l2.getStyleClass().remove("activa");
        i5l3.getStyleClass().remove("activa");
        i5l4.getStyleClass().remove("activa");
        i5l5.getStyleClass().remove("activa");
    }

    public void seleccionar(MouseEvent event){
        casillaSeleccionada = (Label) event.getSource();
        desmarcarTodas();
        casillaSeleccionada.getStyleClass().add("activa");
    }

    @FXML
    public void introducirLetra(ActionEvent event) {
        Button botonPulsado = (Button) event.getSource();
        if (casillaSeleccionada != null) {
            casillaSeleccionada.setText(botonPulsado.getText());
            String id = casillaSeleccionada.getId();
            int fila = Integer.parseInt(id.substring(1, 2)); // Extrae la fila
            int col = Integer.parseInt(id.substring(3)); // Extrae la columna
            col++;

            if (col > 5) {
                casillaSeleccionada.getStyleClass().remove("activa");
                casillaSeleccionada = null;
                return;
            }
            String nuevoId = "i" + fila + "l" + col;

            for (Node node : tablero.getChildren()) {
                if (node instanceof Label && node.getId().equals(nuevoId)) {
                    casillaSeleccionada.getStyleClass().remove("activa");
                    casillaSeleccionada = (Label) node;
                    casillaSeleccionada.getStyleClass().add("activa");
                    break;
                }
            }
        }
    }

    @FXML
    public void borrar(ActionEvent event) {
        if (casillaSeleccionada != null) {
            casillaSeleccionada.setText("");
            String id = casillaSeleccionada.getId();
            int fila = Integer.parseInt(id.substring(1, 2));
            int col = Integer.parseInt(id.substring(3));
            col--;
            if (col < 1) {
                // No permitimos retroceder más allá de la primera columna de la fila actual, asi que no hace absolutamente nada, xd
                col = 1;
            }
            // Verifica que los valores de fila y col son válidos
            if (fila >= 1 && col >= 1) {
                String nuevoId = "i" + fila + "l" + col;
                for (Node node : tablero.getChildren()) {
                    if (node instanceof Label && node.getId().equals(nuevoId)) {
                        // Remueve la clase 'activa' de la casilla seleccionada actual
                        casillaSeleccionada.getStyleClass().remove("activa");
                        casillaSeleccionada = (Label) node;
                        casillaSeleccionada.getStyleClass().add("activa");
                        break;
                    }
                }
            }
        }
    }

    @FXML
    public void comprobarPalabra(ActionEvent event) {
        // Verifica si todas las casillas de la fila actual están completas
        boolean filaCompleta = true;
        for (int col = 1; col <= 5; col++) {
            String casillaId = "i" + filaActual + "l" + col;
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            if (casilla.getText().isEmpty()) {
                filaCompleta = false;
                break;
            }
        }

        // Si la fila actual no está completa, muestra un mensaje de advertencia
        if (!filaCompleta) {
            Alert faltanletras = new Alert(Alert.AlertType.INFORMATION);
            faltanletras.setTitle("Ojo");
            faltanletras.setHeaderText("Aviso");
            faltanletras.setContentText("Por favor, completa todas las casillas de la fila actual antes de comprobar la palabra.");
            faltanletras.showAndWait();
            return;
        }

        StringBuilder palabraIntroducida = new StringBuilder();
        for (int col = 1; col <= 5; col++) {
            String casillaId = "i" + filaActual + "l" + col;
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            palabraIntroducida.append(casilla.getText());
        }

        String palabraOculta = this.palabraOculta.toUpperCase();
        String palabraUsuario = palabraIntroducida.toString().toUpperCase();

        for (int col = 0; col < 5; col++) {
            String casillaId = "i" + filaActual + "l" + (col + 1);
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            char letraUsuario = palabraUsuario.charAt(col);
            char letraOculta = palabraOculta.charAt(col);

            if (letraUsuario == letraOculta) {
                casilla.getStyleClass().removeAll("normal", "existe");
                casilla.getStyleClass().add("correcta");
            } else if (palabraOculta.contains(String.valueOf(letraUsuario))) {
                casilla.getStyleClass().removeAll("normal", "correcta");
                casilla.getStyleClass().add("existe");
            } else {
                casilla.getStyleClass().removeAll("existe", "correcta");
                casilla.getStyleClass().add("normal");
            }
        }
        filaActual++;
        if (filaActual <= 5) {
            String nuevoId = "i" + filaActual + "l1";

            Node siguienteCasilla = tablero.lookup("#" + nuevoId);
            if (siguienteCasilla instanceof Label) {
                if (casillaSeleccionada != null) {
                    casillaSeleccionada.getStyleClass().remove("activa");
                }
                casillaSeleccionada = (Label) siguienteCasilla;
                casillaSeleccionada.getStyleClass().add("activa");
            }
        } else {
            if (casillaSeleccionada != null) {
                casillaSeleccionada.getStyleClass().remove("activa");
                casillaSeleccionada = null;
            }
        }
    }
}

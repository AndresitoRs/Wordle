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

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ResourceBundle;

public class WordleController implements Initializable {

    @FXML
    Resultado info;
    private String palabraOculta;
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
        palabraOculta = obtenerPalabraAleatoria("src/main/resources/palabras.txt");
        iniciarPartida();
        info.limpiar();
    }

    private String obtenerPalabraAleatoria(String rutaFichero) {
        try {
            // Lee todo el contenido del fichero
            String contenido = new String(Files.readAllBytes(Paths.get(rutaFichero)));
            // Separa las palabras por espacios
            String[] palabras = contenido.split(" ");
            // Selecciona una palabra aleatoria
            Random random = new Random();
            int indiceAleatorio = random.nextInt(palabras.length);
            return palabras[indiceAleatorio];
        } catch (IOException e) {
            e.printStackTrace();
            // En caso de error, devuelve una palabra por defecto
            return "ERROR";
        }
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
                col = 1;
            }
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
        boolean filaCompleta = true;
        for (int col = 1; col <= 5; col++) {
            String casillaId = "i" + filaActual + "l" + col;
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            if (casilla.getText().isEmpty()) {
                filaCompleta = false;
                break;
            }
        }
        if (!filaCompleta) {
            System.out.println("Por favor, completa todas las casillas de la fila actual antes de comprobar la palabra.");
            return; // Salimos del método ya que no se cumplen los requisitos
        }

        StringBuilder palabraIntroducida = new StringBuilder();
        for (int col = 1; col <= 5; col++) {
            String casillaId = "i" + filaActual + "l" + col;
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            palabraIntroducida.append(casilla.getText());
        }

        String palabraOculta = this.palabraOculta.toUpperCase();
        String palabraUsuario = palabraIntroducida.toString().toUpperCase();
        boolean adivinoPalabra = true;

        for (int col = 0; col < 5; col++) {
            String casillaId = "i" + filaActual + "l" + (col + 1);
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            char letraUsuario = palabraUsuario.charAt(col);
            char letraOculta = palabraOculta.charAt(col);

            if (letraUsuario == letraOculta) {
                // Si la letra coincide exactamente en la posición correcta, cambia a "correcta"
                casilla.getStyleClass().removeAll("normal", "existe");
                casilla.getStyleClass().add("correcta");
            } else if (palabraOculta.contains(String.valueOf(letraUsuario))) {
                // Si la letra está en la palabra oculta pero no en la posición correcta, cambia a "existe"
                casilla.getStyleClass().removeAll("normal", "correcta");
                casilla.getStyleClass().add("existe");
                adivinoPalabra = false;
            } else {
                casilla.getStyleClass().removeAll("existe", "correcta");
                casilla.getStyleClass().add("normal");
                adivinoPalabra = false;
            }
        }

        if (adivinoPalabra) {
            info.ganar();
            desactivarTodasLasCasillas();
        } else if (filaActual == 5) {
            desactivarCasillasFila(filaActual);
            info.perder();
        } else {
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
            }
        }
    }

    private void desactivarCasillasFila(int fila) {
        for (int col = 1; col <= 5; col++) {
            String casillaId = "i" + fila + "l" + col;
            Label casilla = (Label) tablero.lookup("#" + casillaId);
            casilla.setDisable(true);
        }
    }

    private void desactivarTodasLasCasillas() {
        for (int fila = 1; fila <= 5; fila++) {
            desactivarCasillasFila(fila);
        }
    }
}

package ra5.eurovision.controlador;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import ra5.eurovision.modelo.Festival;
import ra5.eurovision.modelo.PaisExcepcion;

import java.io.File;
import java.io.IOException;

public class FestivalController {
    @FXML
    private TextField txtPais;

    @FXML
    private TextArea areaTexto;

    @FXML
    private Button mostrarPuntosButton;

    @FXML
    private Button mostrarGanadorButton;

    @FXML
    private CheckBox guardarCheckbox;
    private Festival festival;
    public FestivalController() {
        festival = new Festival();
    }



    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }



    private void cogerFoco() {
        txtPais.requestFocus();
        txtPais.selectAll();

    }

    @FXML
    void clear(ActionEvent event) {
        areaTexto.setText("");
        cogerFoco();

    }
    @FXML
    private void leerVotaciones(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            areaTexto.setPromptText("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void mostrarPuntos(ActionEvent event) {
        String pais = txtPais.getText();
        try {
            int puntos = Festival.puntuacionDe(pais);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Puntos de " + pais, "Puntos: " + puntos);
        } catch (PaisExcepcion e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void mostrarGanador(ActionEvent event) {
        String ganador = Festival.ganador();
        areaTexto.setText("El ganador es: " + ganador);
    }

    @FXML
    private void guardarResultados(ActionEvent event) {
        try {
            if (guardarCheckbox.isSelected()){
                festival.guardarResultados();
            }
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo guardar los resultados.");
        }
    }


}


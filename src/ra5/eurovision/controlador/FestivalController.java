package ra5.eurovision.controlador;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class FestivalController {


    public FestivalController() {


    }



    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }



    private void cogerFoco() {
//        txtPais.requestFocus();
//        txtPais.selectAll();

    }

    @FXML
    void clear(ActionEvent event) {
//        areaTexto.setText("");
//        cogerFoco();

    }
    @FXML
    private void leerVotaciones(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        }
    }

}


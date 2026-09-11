package ni.edu.uam.empresaviews.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private void abrirClientes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/empresaviews/registro-clientes.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Clientes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirServicio(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ni/edu/uam/empresaviews/solicitud-servicio.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Servicios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void salirSistema(ActionEvent event) {
        System.exit(0);
    }
}

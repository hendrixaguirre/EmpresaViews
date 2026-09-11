package ni.edu.uam.empresaviews.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class ClienteController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbTipoCliente;
    @FXML
    private TextField txtDocumento;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnSeleccionarDocumento;

    @FXML
    private void initialize() {
        cmbTipoCliente.getItems().setAll("Persona Natural", "Organización", "Fundación");
    }


    @FXML
    private void seleccionarDocumento() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo Texto", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo Word", "*.docx"),
                new FileChooser.ExtensionFilter("Archivo Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivo PowerPoint", "*.pptx")
        );
        File f = fc.showOpenDialog(btnSeleccionarDocumento.getScene().getWindow());
        if (f != null) {
            txtDocumento.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio() {

        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        File f = dc.showDialog(null);

        if (f != null) {
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void registrarCliente() {
        if(!validarFormulario()){
            return;
        }
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText("¿Seguro que quiere registrar el cliente?");
        confirmacion.setContentText("Cliente: " + txtNombre.getText());

        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cliente registrado");
            alert.setHeaderText("Cliente registrado");
            alert.setContentText("Cliente registrado");
            limpiarControles();
        }
    }

    private boolean validarFormulario(){
        String nombre = txtNombre.getText().trim();
        String responsable = txtCorreo.getText().trim();
        String descripcion = txtTelefono.getText().trim();
        String archivo = txtDocumento.getText().trim();
        String directorio = txtDirectorio.getText().trim();
        String tipoCliente = cmbTipoCliente.getValue();

        if (nombre.isEmpty() || responsable.isEmpty() || descripcion.isEmpty() || archivo.isEmpty() || directorio.isEmpty() || tipoCliente == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor, complete todos los campos del formulario.");
            alert.showAndWait();
            return false;
        }else {
            return true;
        }
    }

    @FXML
    private void limpiarControles(){
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        cmbTipoCliente.getSelectionModel().clearSelection();
        txtDocumento.clear();
        txtDirectorio.clear();
    }

    @FXML
    private void cerrarSistema(ActionEvent event) {
        System.exit(0);
    }
}

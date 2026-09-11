package ni.edu.uam.empresaviews.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class ServicioController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTipoCliente;
    @FXML
    private TextArea txtAreaAsunto;
    @FXML
    private ComboBox<String> cmbTipoServicio;
    @FXML
    private RadioButton rbtnAlto;
    @FXML
    private RadioButton rbtnMedio;
    @FXML
    private RadioButton rbtnBajo;
    @FXML
    private TextArea txtAreaDescripcion;
    @FXML
    private TextField txtArchivo;
    @FXML
    private TextField txtCarpeta;
    @FXML
    private Button btnSeleccionarArchivo;


    @FXML
    private void initialize() {
        cmbTipoServicio.getItems().setAll("Servicio 1", "Servicio 2", "Servicio 3");
    }

    @FXML
    private void seleccionarArchivoAdjunto() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo Texto", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo Word", "*.docx"),
                new FileChooser.ExtensionFilter("Archivo Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivo PowerPoint", "*.pptx")
        );
        File f = fc.showOpenDialog(btnSeleccionarArchivo.getScene().getWindow());
        if (f != null) {
            txtArchivo.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarCarpetaEvidencia() {

        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        File f = dc.showDialog(null);

        if (f != null) {
            txtCarpeta.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void crearSolicitud() {
        if(!validarFormulario()){
            return;
        }
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText("¿Seguro que quiere crear la solicitud?");
        confirmacion.setContentText("Solicitud: " + txtAreaAsunto.getText());

        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Solicitud creada");
            alert.setHeaderText("Solicitud creada");
            alert.setContentText("Solicitud creada");
            limpiarControles();
        }
    }

    private boolean validarFormulario(){
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String asunto = txtAreaAsunto.getText().trim();
        String tipoServicio = cmbTipoServicio.getValue();
        boolean prioridadSeleccionada = rbtnAlto.isSelected() || rbtnMedio.isSelected() || rbtnBajo.isSelected();
        String descripcion = txtAreaDescripcion.getText().trim();
        String archivo = txtArchivo.getText().trim();
        String directorio = txtCarpeta.getText().trim();


        if (nombre.isEmpty() || correo.isEmpty() || asunto.isEmpty() || descripcion.isEmpty() || archivo.isEmpty() || directorio.isEmpty() || tipoServicio == null || !prioridadSeleccionada) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos o prioridad no seleccionada");
            alert.setContentText("Por favor, complete todos los campos del formulario y seleccione una prioridad.");
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
        txtTipoCliente.clear();
        cmbTipoServicio.getSelectionModel().clearSelection();
        txtAreaAsunto.clear();
        rbtnAlto.setSelected(false);
        rbtnMedio.setSelected(false);
        rbtnBajo.setSelected(false);
        txtArchivo.clear();
        txtCarpeta.clear();
        txtAreaDescripcion.clear();
    }

    @FXML
    private void cerrarSistema(ActionEvent event) {
        System.exit(0);
    }
}

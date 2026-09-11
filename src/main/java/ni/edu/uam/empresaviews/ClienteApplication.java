package ni.edu.uam.empresaviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ni.edu.uam.empresaviews.model.Cliente;

import java.io.IOException;

public class ClienteApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClienteApplication.class.getResource("/ni/edu/uam/empresaviews/registro-clientes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro Clientes");
        stage.setScene(scene);
        stage.show();
    }
}
